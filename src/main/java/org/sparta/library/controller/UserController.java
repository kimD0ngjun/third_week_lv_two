package org.sparta.library.controller;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.sparta.library.model.dto.userdto.UserRequestDto;
import org.sparta.library.model.dto.userdto.UserResponseDto;
import org.sparta.library.service.userservice.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 등록 기능
    @PostMapping("/user")
    @Timed("user.timed")
    @Counted("user.count")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }
}
