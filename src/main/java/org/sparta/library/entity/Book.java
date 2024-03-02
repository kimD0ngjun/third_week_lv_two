package org.sparta.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.library.dto.bookDto.BookRequestDto;

import java.util.Date;

@Entity
@Table(name = "book")
@NoArgsConstructor
@Getter
@Setter
public class Book extends Timestamped {
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

    public Book(BookRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writer = requestDto.getWriter();
        this.language = requestDto.getLanguage();
        this.publisher = requestDto.getPublisher();
    }
}
