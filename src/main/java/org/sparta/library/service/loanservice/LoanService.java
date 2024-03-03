package org.sparta.library.service.loanservice;

import org.sparta.library.model.dto.loanDto.LoanResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanService {
    // 객체 생성(도서 대출)
    //TODO: 객체를 생성하려면, 전달받은 도서 ID를 기반으로 대출 DB에서 조회한다
    // 1. 도서(들)가 조회되지 않으면, 생성 가능
    // 2. 도서(들)가 조회됐지만, 반납 여부가 true이면 생성 가능
    ResponseEntity<String> createLoan(Long userId, Long bookId);

    // 객체 수정(도서 반납)
    ResponseEntity<String> updateLoan(Long userId, Long bookId);

    // 조건부 조회(회원 ID 외래키 기반)
    List<LoanResponseDto> getLoans(Long userId);
}
