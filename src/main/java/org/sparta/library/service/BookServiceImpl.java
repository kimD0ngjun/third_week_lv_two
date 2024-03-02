package org.sparta.library.service;

import lombok.RequiredArgsConstructor;
import org.sparta.library.dto.bookDto.BookRequestDto;
import org.sparta.library.dto.bookDto.BookResponseDto;
import org.sparta.library.entity.Book;
import org.sparta.library.respository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookResponseDto createBook(BookRequestDto requestDto) {
        // request dto -> entitiy
        Book book = new Book(requestDto);
        return null;
    }

    @Override
    public BookResponseDto getBook(Long bookId) {
        return null;
    }

    @Override
    public List<BookResponseDto> getBooks() {
        return null;
    }
}
