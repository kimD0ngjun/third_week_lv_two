package org.sparta.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.library.model.dto.bookdto.BookRequestDto;
import org.sparta.library.utility.BookTimestamped;

@Entity
@Table(name = "book")
@NoArgsConstructor
@Getter
@Setter
public class Book extends BookTimestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "writer", nullable = false)
    private String writer;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    @Column(name = "borrow", nullable = false)
    private Boolean whetherBorrow;

    public Book(BookRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.language = requestDto.getLanguage();
        this.publisher = requestDto.getPublisher();
        this.whetherBorrow = true; // 책이 생성될 때는 언제나 대여 가능하므로
    }
}
