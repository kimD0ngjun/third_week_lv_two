package org.sparta.library.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.library.model.dto.userdto.UserRequestDto;

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

    @Column(name = "penalty_elapsed_date")
    private LocalDateTime penalty; // TODO: 패널티 적용을 위한 필드 추가

    public User(UserRequestDto requestDto) {
        this.name = requestDto.getName();
        this.gender = requestDto.getGender();
        this.identificationNumber = requestDto.getIdentificationNumber();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.address = requestDto.getAddress();
        this.penalty = null; // 초기 생성은 패널티 x
    }
}
