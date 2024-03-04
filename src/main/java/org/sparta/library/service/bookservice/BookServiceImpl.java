package org.sparta.library.service.bookservice;

import lombok.RequiredArgsConstructor;
import org.sparta.library.model.dto.bookdto.BookRequestDto;
import org.sparta.library.model.dto.bookdto.BookResponseDto;
import org.sparta.library.model.entity.Book;
import org.sparta.library.respository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    // save
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

    // get unit
    @Override
    public BookResponseDto getBook(Long bookId) {
        // find book
        Book book = findBook(bookId);

        // entity -> response dto
        return new BookResponseDto(book);
    }

    // get all
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
