package za.ac.nwu.ac.account_system.account;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class AccountService {

    public List<AccountType> showAccounts() {
        return List.of(
                new AccountType(
                        1L,
                        "Vitality Points",
                        "Vitality Points",
                        LocalDate.of(2021, Month.SEPTEMBER, 10)
                )
        ) ;
    }
}
