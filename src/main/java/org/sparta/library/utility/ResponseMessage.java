package org.sparta.library.utility;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {
    BORROW_SUCCESS("대출 처리에 성공했습니다."),
    WRONG_BORROW("사용자 혹은 도서가 존재하지 않습니다."),
    IMPOSSIBLE_BORROW("현재 대출 중입니다."),
    RETURN_SUCCESS("반납 처리에 성공했습니다."),
    DUPLICATED_RETURN("이미 반납 처리됐습니다."),
    WRONG_RETURN("존재하지 않는 대출 정보입니다.");

    private final String message;
}
