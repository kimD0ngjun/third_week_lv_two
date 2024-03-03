package org.sparta.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BookTimestamped {

    @CreatedDate
    @Column(name = "registration_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    @Column
//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime modifiedAt;
}
