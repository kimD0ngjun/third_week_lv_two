package org.sparta.library.model.dto.bookdto;

import lombok.Getter;
import org.sparta.library.model.entity.Book;

import java.time.LocalDateTime;

@Getter
public class BookResponseDto {
    private Long bookId;
    private String title;
    private String writer;
    private String language;
    private String publisher;
    private LocalDateTime registrationDate;
    private Boolean whetherBorrow;

    public BookResponseDto(Book book) {
        this.bookId = book.getBookId();
        this.title = book.getTitle();
        this.writer = book.getWriter();
        this.language = book.getLanguage();
        this.publisher = book.getPublisher();
        this.registrationDate = book.getCreatedAt();
        this.whetherBorrow = book.getWhetherBorrow();
    }
}
