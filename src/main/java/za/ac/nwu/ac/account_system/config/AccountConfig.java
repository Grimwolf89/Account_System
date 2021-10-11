package za.ac.nwu.ac.account_system.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {

   /* @Bean
    CommandLineRunner commandLineRunner(AccountRepository repository) {
        return args -> {
            AccountType miles = new AccountType(
                    "MILES",
                    "Discovery Reward Miles",
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


    }*/
}
