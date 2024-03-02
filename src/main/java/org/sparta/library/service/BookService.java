package org.sparta.library.service;

import org.sparta.library.dto.bookDto.BookRequestDto;
import org.sparta.library.dto.bookDto.BookResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    // 객체 생성
    BookResponseDto createBook(BookRequestDto requestDto);

    // 단일 조회
    BookResponseDto getBook(Long bookId);

    // 전원 조회
    List<BookResponseDto> getBooks();
}
