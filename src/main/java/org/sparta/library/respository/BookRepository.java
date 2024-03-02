package org.sparta.library.respository;

import org.sparta.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByOrderByCreatedAtAsc();
}
// Spring Data JPA에서는 JpaRepository 인터페이스를 구현하는 클래스를 자동으로 생성
// 자동으로 SimpleJpaRepository 클래스를 생성해 주고, 이 클래스를 Spring ‘Bean’으로 등록