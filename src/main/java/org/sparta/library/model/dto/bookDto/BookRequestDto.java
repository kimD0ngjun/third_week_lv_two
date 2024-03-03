package org.sparta.library.model.dto.bookDto;

import lombok.Getter;

import java.util.Date;

@Getter
public class BookRequestDto {
    private String title;
    private String writer;
    private String language;
    private String publisher;
    private Date registrationDate;
}
