package com.pakie.hospital_app.service;

import com.pakie.hospital_app.model.User;
import com.pakie.hospital_app.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
