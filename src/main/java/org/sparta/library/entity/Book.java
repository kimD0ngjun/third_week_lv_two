package org.sparta.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Book {
    private Long bookId;
    private String title;
    private String writer;
    private String language;
    private String publisher;
    private Date registrationDate;
}
