package za.ac.nwu.ac.account_system.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.account_system.account.AccountRepository;
import za.ac.nwu.ac.account_system.account.AccountType;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository repository) {
        return args -> {
            AccountType miles = new AccountType(
                    "POINTS",
                    "Reward Points",
                    LocalDate.of(2021, Month.SEPTEMBER, 28)
            );
            AccountType plays = new AccountType(
                    "PLAYS",
                    "Plays",
                    LocalDate.of(2021, Month.SEPTEMBER, 28)
            );
            AccountType zar = new AccountType(
                    "ZAR",
                    "Rand",
                    LocalDate.of(2021, Month.SEPTEMBER, 27)
            );
            repository.saveAll(
                    List.of(miles, plays, zar)
            );
        };


    }
}
