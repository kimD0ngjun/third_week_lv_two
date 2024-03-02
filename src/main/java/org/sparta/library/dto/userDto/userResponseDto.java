package org.sparta.library.dto.userDto;

import lombok.Getter;
import org.sparta.library.entity.User;

@Getter
public class userResponseDto {
    private Long userId;
    private String name;
    private String gender;
    private String phoneNumber;
    private String address;

    public userResponseDto(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.gender = user.getGender();
        this.phoneNumber = user.getPhoneNumber();
        this.address = user.getAddress();
    }
}
