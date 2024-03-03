package org.sparta.library.dto.loanDto;

import lombok.Getter;
import org.sparta.library.entity.Loan;

@Getter
public class LoanResponseDto {
    private Long loanId;
    private String name;
    private String phoneNumber;
    private String title;
    private String writer;

    public LoanResponseDto(Loan loan) {
        this.loanId = loan.getLoanId();
        this.name = loan.getUser().getName();
        this.phoneNumber = loan.getUser().getPhoneNumber();
        this.title = loan.getBook().getTitle();
        this.writer = loan.getBook().getWriter();
    }
}
