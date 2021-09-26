package za.ac.nwu.ac.account_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class AccountSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountSystemApplication.class, args);
    }

    @GetMapping
    public List<String> hello() {
        return List.of("Initial", "Testing", "Endpoint", "Resolved") ;
    }
}
