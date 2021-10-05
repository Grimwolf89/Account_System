package za.ac.nwu.ac.account_system.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/account-system/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;

    }
    @GetMapping
    public List<AccountType> showAccounts() {
    return accountService.showAccounts();
    }

    @PostMapping("/add")
    public void registerTransaction(@RequestBody AccountTransaction transaction) {
        accountService.addTransaction(transaction);
    }
    @PostMapping("/subtract")
    public void registerSubtractTransaction(@RequestBody AccountTransaction transaction) {
        accountService.subtractTransaction(transaction);
    }
    @GetMapping("/transactions")
    public List<AccountTransaction> showTransactions(){
        return accountService.showTransactions();

    }
    @GetMapping("/member/{id}")
    public List<AccountTransaction> getMemberById(@PathVariable Long id) {
        return accountService.findByMemberAccount(id);
    }
    @GetMapping("/membermiles/{id}")
    public String getMemberMilesById(@PathVariable Long id) {
        return accountService.viewMemberMiles(id);
    }

}

