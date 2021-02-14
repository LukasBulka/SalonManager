package pl.coderslab.SalonManager;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.SalonManager.model.User;
import pl.coderslab.SalonManager.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class DbInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        this.userRepository.deleteAll();

        User admin = new User("Lukasz", "Bulka", "lukas.bulka@op.pl", passwordEncoder.encode("123"), "ADMIN, EMPLOYEE", "");
        User employee = new User("Natasha", "Romanov", "blackwidow@avengers.com", passwordEncoder.encode("123"), "EMPLOYEE", "");
        User user = new User("Tony", "Stark", "ironman@avengers.com", passwordEncoder.encode("123"), "USER", "");

        List<User> users = Arrays.asList(admin, employee, user);
        this.userRepository.saveAll(users);
    }
}
