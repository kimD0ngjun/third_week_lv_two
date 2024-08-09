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
    @Timed(value = "http.requests.timed", description = "책 생성 요청 POST 호출에 걸리는 시간")
    @Counted(value = "http.requests.count", description = "책 생성 요청 POST 호출에 드는 리소스")
    public BookResponseDto createBook(@RequestBody BookRequestDto bookRequestDto) {
        return bookService.createBook(bookRequestDto);
    }

    // 도서 전부 조회
    @GetMapping("/book")
    @Timed(value = "http.requests.timed", description = "책 조회 요청 GET 호출에 걸리는 시간")
    @Counted(value = "http.requests.count", description = "책 조회 요청 GET 호출에 드는 리소스")
    public List<BookResponseDto> getBooks() {
        return bookService.getBooks();
    }

    // 도서 일부 조회
    @GetMapping("/book/{bookId}")
    @Timed(value = "http.requests.timed", description = "특정 책 조회 요청 GET 호출에 걸리는 시간")
    @Counted(value = "http.requests.count", description = "특정 책 조회 요청 GET 호출에 드는 리소스")
    public BookResponseDto getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }
}
