package org.sparta.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Loan {
    private Long loanId;
    private Long userId;
    private Long bookId;
    private Boolean bookReturn;
    private Date loanDate;
    private Date returnDate;
}
