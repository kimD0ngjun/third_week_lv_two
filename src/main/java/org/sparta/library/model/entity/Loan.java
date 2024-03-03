package org.sparta.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.library.utility.LoanTimestamped;

@Entity
@Table(name = "loan")
@NoArgsConstructor
@Getter
@Setter
public class Loan extends LoanTimestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long loanId;

    @ManyToOne // 외래키 지정할 때 쓰는 어노테이션 : ManyToOne, JoinColumn
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    private Book book;

    @Column(name = "book_return", nullable = false)
    private Boolean bookReturn;
//
//    @Column(name = "loan_date", nullable = false)
//    private LocalDateTime loanDate;
//
//    @Column(name = "return_date") // 반납 전에는 null로 두고, 반납 후에 그 값을 기록시키기
//    private LocalDateTime returnDate;

    public Loan(User user, Book book) {
        this.user = user;
        this.book = book;
        this.bookReturn = false; // 대여 당시에는 책 반납 안 된 상태 초기화
    }
}
