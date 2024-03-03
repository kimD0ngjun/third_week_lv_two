package org.sparta.library.service.loanservice;

import jakarta.transaction.Transactional;
import org.sparta.library.model.dto.loanDto.LoanResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanService {
    // 객체 생성(도서 대출)
    @Transactional
    ResponseEntity<String> createLoan(Long userId, Long bookId);

    // 객체 수정(도서 반납)
    @Transactional
    ResponseEntity<String> updateLoan(Long userId, Long bookId);

    // 조건부 조회(회원 ID 외래키 기반)
    List<LoanResponseDto> getLoans(Long userId);
}
