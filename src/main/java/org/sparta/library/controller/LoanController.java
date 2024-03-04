package org.sparta.library.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.library.model.dto.loandto.LoanResponseDto;
import org.sparta.library.service.loanservice.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    // 대출 처리
    @PostMapping("/loan/{userId}")
    public ResponseEntity<String> createLoan(@PathVariable Long userId, @RequestParam Long bookId) {
        return loanService.createLoan(userId, bookId);
    }

    // 대출 반납
    @PutMapping("/loan/{userId}") // 수정시간 업뎃 안 됨
    public ResponseEntity<String> updateLoan(@PathVariable Long userId, @RequestParam Long bookId) {
        return loanService.updateLoan(userId, bookId);
    }

    // 회원 기반 대출 내역 조회
    @GetMapping("/loan/{userId}")
    public List<LoanResponseDto> getLoans(@PathVariable Long userId) {
        return loanService.getLoans(userId);
    };
}
