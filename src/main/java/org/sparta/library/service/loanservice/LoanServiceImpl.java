package org.sparta.library.service.loanservice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sparta.library.model.dto.loanDto.LoanResponseDto;
import org.sparta.library.model.entity.Book;
import org.sparta.library.model.entity.Loan;
import org.sparta.library.model.entity.User;
import org.sparta.library.respository.BookRepository;
import org.sparta.library.respository.LoanRepository;
import org.sparta.library.respository.UserRepository;
import org.sparta.library.utility.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    // 객체 생성(도서 대출)
    @Override
    @Transactional
    public ResponseEntity<String> createLoan(Long userId, Long bookId) {
        // 도서 ID 기반 조회
        List<Loan> loanList = loanRepository.findByBook_BookId(bookId);

        // 조건부 new entity
        if (loanList.isEmpty() || allBooksReturned(loanList)) {
            Optional<User> userOptional = userRepository.findById(userId);
            Optional<Book> bookOptional = bookRepository.findById(bookId);

            if (userOptional.isPresent() && bookOptional.isPresent()) {
                User user = userOptional.get();
                Book book = bookOptional.get();

                // 새로운 대출 entity 생성 및 저장
                Loan loan = new Loan(user, book);
                loanRepository.save(loan);

                return ResponseEntity.ok(ResponseMessage.BORROW_SUCCESS.getMessage());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseMessage.WRONG_BORROW.getMessage());
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseMessage.IMPOSSIBLE_BORROW.getMessage());
    }

    // 객체 수정(도서 반납)
    @Override
    @Transactional
    public ResponseEntity<String> updateLoan(Long userId, Long bookId) {
        // 도서 ID와 회원 ID로 Loan 엔티티 조회
        Loan loan = loanRepository.findByUser_UserIdAndBook_BookId(userId, bookId);

        // 조건부 엔티티 수정
        if (loan != null && !loan.getBookReturn()) {
            loan.setBookReturn(true); // 반납 처리
            loan.setModifiedAt(LocalDateTime.now()); // 수정된 시간 설정

            return ResponseEntity.ok(ResponseMessage.RETURN_SUCCESS.getMessage());
        } else if (loan != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseMessage.DUPLICATED_RETURN.getMessage());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseMessage.WRONG_RETURN.getMessage());
    }

    // 조건부 조회(회원 ID 외래키 기반)
    @Override
    public List<LoanResponseDto> getLoans(Long userId) {
        List<Loan> userLoanList = loanRepository.findByUser_UserId(userId);

        return userLoanList.stream().sorted(Comparator.comparing(Loan::getCreatedAt))
                .map(LoanResponseDto::new).collect(Collectors.toList());
    }

    // 모든 대출이 반환되었는지 확인하는 메소드
    private boolean allBooksReturned(List<Loan> loans) {
        for (Loan loan : loans) {
            if (!loan.getBookReturn()) {
                return false;
            }
        }
        return true;
    }
}
