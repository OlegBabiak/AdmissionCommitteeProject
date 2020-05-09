package lviv.university.committee.service;

import lviv.university.committee.dtos.UserRegistrationRequest;
import lviv.university.committee.entities.User;
import lviv.university.committee.entities.UserRole;
import lviv.university.committee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private static final Set<UserRole> USER_ROLES_DEFAULT = Collections.singleton(UserRole.ROLE_ENTRANT);

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegistrationRequest userDto) {

        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUserName(),
                userDto.getEmail(),
                USER_ROLES_DEFAULT
        );

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

}
