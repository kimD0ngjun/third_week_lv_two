package org.sparta.library.utility;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class LoanTimestamped {

    @CreatedDate
    @Column(name = "borrow_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;

    public Boolean givePenalty() {
        Duration duration = Duration.between(createdAt, modifiedAt);
        long days = duration.toDays();

        return days > 7; // 반납일이 곧 패널티 시작일
    }
}
