package org.sparta.library.service.userservice;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sparta.library.dto.userDto.UserRequestDto;
import org.sparta.library.dto.userDto.UserResponseDto;
import org.sparta.library.entity.userentity.User;
import org.sparta.library.respository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // save
    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto requestDto) {
        // request dto -> entity
        User user = new User(requestDto);

        // save db
        User saveUser = userRepository.save(user);

        // entity -> response dto
        return new UserResponseDto(saveUser);
    }
}
