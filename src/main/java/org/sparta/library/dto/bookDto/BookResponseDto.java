package org.sparta.library.dto.bookDto;

import lombok.Getter;
import org.sparta.library.entity.Book;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class BookResponseDto {
    private Long bookId;
    private String title;
    private String writer;
    private String language;
    private String publisher;
    private LocalDateTime registrationDate;

    public BookResponseDto(Book book) {
        this.bookId = book.getBookId();
        this.title = book.getTitle();
        this.writer = book.getWriter();
        this.language = book.getLanguage();
        this.publisher = book.getPublisher();
        this.registrationDate = book.getCreatedAt();
    }
}
