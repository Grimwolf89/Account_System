package za.ac.nwu.ac.account_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.ac.account_system.account.AccountType;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class AccountSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountSystemApplication.class, args);
    }


}
