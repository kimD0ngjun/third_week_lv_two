package org.sparta.library.service;

import lombok.RequiredArgsConstructor;
import org.sparta.library.dto.bookDto.BookRequestDto;
import org.sparta.library.dto.bookDto.BookResponseDto;
import org.sparta.library.entity.Book;
import org.sparta.library.respository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional
    public BookResponseDto createBook(BookRequestDto requestDto) {
        // request dto -> entity
        Book book = new Book(requestDto);

        // save db
        Book saveBook = bookRepository.save(book);

        // entity -> response dto
        return new BookResponseDto(saveBook);
    }

    @Override
    public BookResponseDto getBook(Long bookId) {
        // find book
        Book book = findBook(bookId);

        // entity -> response dto
        return new BookResponseDto(book);
    }

    @Override
    public List<BookResponseDto> getBooks() {
        return bookRepository.findAllByOrderByCreatedAtAsc().stream()
                .map(BookResponseDto::new).toList();
    }

    private Book findBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(
                () -> new IllegalArgumentException("The id doesn't exist")
        );
    }
}
