package org.sparta.library.respository;

import org.sparta.library.model.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    // 도서 ID 기반 엔티티 조회 메소드
    List<Loan> findByBook_BookId(Long bookId);

    // 도서 ID와 회원 ID로 Loan 엔티티 조회 메소드
    Loan findByUser_UserIdAndBook_BookId(Long userId, Long bookId);

    // 회원 ID로 Loan 엔티티 조회 메소드
    List<Loan> findByUser_UserId(Long userId);
}
