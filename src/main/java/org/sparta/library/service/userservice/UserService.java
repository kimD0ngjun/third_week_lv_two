package org.sparta.library.service.userservice;

import jakarta.transaction.Transactional;
import org.sparta.library.dto.userDto.UserRequestDto;
import org.sparta.library.dto.userDto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    // 객체 생성
    @Transactional
    UserResponseDto createUser(UserRequestDto userRequestDto);
}
