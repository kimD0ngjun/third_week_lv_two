package org.sparta.library.dto.bookDto;

import lombok.Getter;

import java.util.Date;

@Getter
public class BookResponseDto {
    private Long bookId;
    private String title;
    private String writer;
    private String language;
    private String publisher;
    private Date registrationDate;
}
