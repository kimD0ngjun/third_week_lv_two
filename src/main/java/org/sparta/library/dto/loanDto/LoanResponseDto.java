package org.sparta.library.dto.loanDto;

import lombok.Getter;
import org.sparta.library.entity.loanentity.Loan;

@Getter
public class LoanResponseDto {
    private String name;
    private String phoneNumber;
    private String title;
    private String writer;

    public LoanResponseDto(Loan loan) {
        this.name = loan.getUser().getName();
        this.phoneNumber = loan.getUser().getPhoneNumber();
        this.title = loan.getBook().getTitle();
        this.writer = loan.getBook().getWriter();
    }
}
