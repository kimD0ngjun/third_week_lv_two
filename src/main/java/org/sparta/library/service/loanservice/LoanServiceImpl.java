package org.sparta.library.service.loanservice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sparta.library.dto.loanDto.LoanResponseDto;
import org.sparta.library.entity.Book;
import org.sparta.library.entity.Loan;
import org.sparta.library.entity.User;
import org.sparta.library.respository.BookRepository;
import org.sparta.library.respository.LoanRepository;
import org.sparta.library.respository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    // 객체 생성(도서 대출)
    //TODO: 객체를 생성하려면, 전달받은 도서 ID를 기반으로 대출 DB에서 조회한다
    // 1. 도서(들)가 조회되지 않으면, 생성 가능
    // 2. 도서(들)가 조회됐지만, 반납 여부가 true이면 생성 가능
    @Override
    @Transactional
    public ResponseEntity<String> createLoan(Long bookId, Long userId) {
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

                return ResponseEntity.ok("대출 처리에 성공했습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자 혹은 도서가 존재하지 않습니다.");
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("현재 대출 중입니다.");
    }

    // 객체 수정(도서 반납)
    @Override
    @Transactional
    public ResponseEntity<String> updateLoan(Long bookId, Long userId) {
        return null;
    }

    // 조건부 조회(회원 ID 외래키 기반)
    @Override
    public List<LoanResponseDto> getLoans(Long userId) {
        return null;
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
