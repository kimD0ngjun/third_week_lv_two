package org.sparta.library.model.dto.userDto;

import lombok.Getter;
import org.sparta.library.model.entity.User;

@Getter
public class UserResponseDto {
    private Long userId;
    private String name;
    private String gender;
    private String phoneNumber;
    private String address;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.gender = user.getGender();
        this.phoneNumber = user.getPhoneNumber();
        this.address = user.getAddress();
    }
}
