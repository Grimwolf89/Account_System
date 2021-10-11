package za.ac.nwu.ac.account_system.account.BusinessLogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.account_system.account.DataAccess.AccountRepository;
import za.ac.nwu.ac.account_system.account.DataAccess.AccountTransaction;
import za.ac.nwu.ac.account_system.account.DataAccess.AccountType;
import za.ac.nwu.ac.account_system.account.DataAccess.TransactionRepository;
import za.ac.nwu.ac.account_system.exceptions.MemberNotFoundException;

import java.util.List;

@Component
public class AccountService {

    private static  final Logger LOGGER = LoggerFactory.getLogger(AccountTransaction.class);
    private static TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    /*private final TransactionRepository transactionRepository;*/

    @Autowired
    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public static void addTransaction(AccountTransaction transaction) {
        transactionRepository.save(transaction);
        System.out.println(transaction.toString());
    }

    public static void subtractTransaction(AccountTransaction transaction){
        transaction.setAmount(0 - transaction.getAmount());
        transactionRepository.save(transaction);
        System.out.println(transaction.toString());
    }

    public List<AccountType> showAccounts() {
        return accountRepository.findAll();
    }

    public List<AccountTransaction> showTransactions() {
        return transactionRepository.findAll();
    }

    public List<AccountTransaction> findByMemberAccount(Long id) {

        return transactionRepository.findByMemberId(id);
    }

    public String viewMemberMiles(Long id) {
        List<AccountTransaction> accountTransactionList = findByMemberAccount(id);
        Long availableMiles = 0L;

        for (int i = 0; i < accountTransactionList.size(); i++) {
            availableMiles += accountTransactionList.get(i).getAmount();
        }

        // Exception for an empty list of transactions
        if (accountTransactionList.isEmpty()) {
            LOGGER.isDebugEnabled();
            LOGGER.info("No member found with ID: " + id.toString());
            throw new MemberNotFoundException("No member found with ID: " + id.toString());
        }
        LOGGER.info("The miles for Member: "+ id.toString() + " is " +  availableMiles + " Miles");
        return "The miles for Member: "+ id.toString() + " is " +  availableMiles + " Miles ";
    }

}

