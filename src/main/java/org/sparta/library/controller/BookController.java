package org.sparta.library.controller;

import lombok.RequiredArgsConstructor;
import org.sparta.library.model.dto.bookDto.BookRequestDto;
import org.sparta.library.model.dto.bookDto.BookResponseDto;
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
    public BookResponseDto createBook(@RequestBody BookRequestDto bookRequestDto) {
        return bookService.createBook(bookRequestDto);
    }

    // 도서 전부 조회
    @GetMapping("/book")
    public List<BookResponseDto> getBooks() {
        return bookService.getBooks();
    }

    // 도서 일부 조회
    @GetMapping("/book/{bookId}")
    public BookResponseDto getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }
}
