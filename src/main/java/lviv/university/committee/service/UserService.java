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
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Set<UserRole> USER_ROLES_DEFAULT = Collections.singleton(UserRole.ROLE_ENTRANT);
    private final EmailSendingService emailSendingService;

    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       EmailSendingService emailSendingService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailSendingService = emailSendingService;
    }

    public void register(UserRegistrationRequest userDto) {

        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUsername(),
                userDto.getEmail(),
                USER_ROLES_DEFAULT
        );

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmailVerified(false);
        UUID uuid = UUID.randomUUID();
        user.setVerifyEmailHash(uuid.toString());

        userRepository.save(user);


        emailSendingService.sendVerificationEmail(userDto.getEmail(), uuid.toString());
    }

    public void confirmEmail(String hash) {
        userRepository.findByVerifyEmailHash(hash)
                .ifPresent(user -> userRepository.confirmEmail(user.getId()));
    }

}
