package org.sparta.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private Long userId;
    private String name;
    private String gender;
    private String identificationNumber;
    private String address;
}
