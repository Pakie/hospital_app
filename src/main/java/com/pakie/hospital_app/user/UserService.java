package com.pakie.hospital_app.user;

import com.pakie.hospital_app.user.User;
import com.pakie.hospital_app.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
