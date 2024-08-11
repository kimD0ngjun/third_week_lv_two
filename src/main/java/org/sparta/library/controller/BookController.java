package org.sparta.library.controller;

import lombok.RequiredArgsConstructor;
import io.micrometer.core.annotation.*;
import org.sparta.library.model.dto.bookdto.BookRequestDto;
import org.sparta.library.model.dto.bookdto.BookResponseDto;
import org.sparta.library.service.bookservice.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 도서 등록 기능
    @PostMapping("/book")
    @Timed("book.create.timed")
    @Counted("api.book.create.count")
    public BookResponseDto createBook(@RequestBody BookRequestDto bookRequestDto) {
        return bookService.createBook(bookRequestDto);
    }

    // 도서 전부 조회
    @GetMapping("/book")
    @Timed("books.get.timed")
    @Counted("books.get.count")
    public List<BookResponseDto> getBooks() {
        return bookService.getBooks();
    }

    // 도서 일부 조회
    @GetMapping("/book/{bookId}")
    @Timed("book.get.timed")
    @Counted("book.get.count")
    public BookResponseDto getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }
}
