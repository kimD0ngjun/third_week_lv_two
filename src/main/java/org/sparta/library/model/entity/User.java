package org.sparta.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.library.model.dto.userdto.UserRequestDto;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "identification_number", nullable = false, unique = true)
    private String identificationNumber;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "penalty", nullable = false)
    private Boolean penalty; // TODO: 패널티 적용을 위한 필드 추가

    public User(UserRequestDto requestDto) {
        this.name = requestDto.getName();
        this.gender = requestDto.getGender();
        this.identificationNumber = requestDto.getIdentificationNumber();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.address = requestDto.getAddress();
        this.penalty = false; // 초기 생성은 패널티 x
    }

    // 연체 패널티 부여 여부
    public LocalDateTime givePenalty(LocalDateTime createdAt, LocalDateTime modifiedAt) {
        Duration duration = Duration.between(createdAt, modifiedAt);
        long days = duration.toDays();

        if (days > 7) {
            this.penalty = true;
            return modifiedAt; // 반납일이 곧 패널티 시작일
        }

        return null;
    }
}
