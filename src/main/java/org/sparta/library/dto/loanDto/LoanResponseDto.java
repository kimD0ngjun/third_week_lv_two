package org.sparta.library.dto.loanDto;

import lombok.Getter;

@Getter
public class LoanResponseDto {
    private Long loanId;
    private Long userId;
    private Long bookId;
    private Boolean bookReturn;
}
