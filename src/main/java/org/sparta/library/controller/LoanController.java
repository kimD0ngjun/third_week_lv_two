package org.sparta.library.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.library.service.loanservice.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    // 대출 처리
    @PostMapping("/loan/{userId}") // userId와 bookId가 바뀐 거 같은데 서로...??
    public ResponseEntity<String> createLoan(@PathVariable Long userId, @RequestParam Long bookId) {
        return loanService.createLoan(userId, bookId);
    }

    // 대출 반납

    // 회원 기반 대출 내역 조회
}
