package za.ac.nwu.ac.account_system.account;

import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import za.ac.nwu.ac.account_system.exceptions.MemberNotFoundException;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/accounts")
public class AccountController {

    private static  final Logger LOGGER = LoggerFactory.getLogger(AccountTransaction.class);
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;

    }
    @ApiIgnore
    @GetMapping
    public List<AccountType> showAccounts() {
        return accountService.showAccounts();

    }

    @PostMapping("/add")
    public void registerTransaction(@RequestBody AccountTransaction transaction) {
        LOGGER.info("A transaction was created with the following details: {}", transaction.toString());
        accountService.addTransaction(transaction);
    }
    @PostMapping("/subtract")
    public void registerSubtractTransaction(@RequestBody AccountTransaction transaction) {
        LOGGER.info("A transaction was created with the following details: {}", transaction.toString());
        accountService.subtractTransaction(transaction);
    }
    @ApiIgnore
    @GetMapping("/transactions")
    public List<AccountTransaction> showTransactions(){
        LOGGER.info("Transactions List requested");
        return accountService.showTransactions();

    }
    @ApiIgnore
    @GetMapping("/member/{id}")
    public List<AccountTransaction> getMemberById(@PathVariable Long id) {
        return accountService.findByMemberAccount(id);
    }
    @GetMapping("/membermiles/{id}")
    public String getMemberMilesById(@PathVariable Long id) {
        /*String findUser = accountService.viewMemberMiles(id);
        LOGGER.info("XXXXXXXXXXXXXXXX"+findUser);
        if (null == findUser) {
            LOGGER.info("No member found with ID: " + id.toString());
            throw new MemberNotFoundException("No member found with ID: " + id.toString());

        }
        else {

        }*/
        return accountService.viewMemberMiles(id);
    }

}

