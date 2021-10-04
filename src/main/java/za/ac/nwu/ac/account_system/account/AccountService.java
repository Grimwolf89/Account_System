package za.ac.nwu.ac.account_system.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountService {


    private static TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    /*private final TransactionRepository transactionRepository;*/

    @Autowired
    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

   /* public static void registerTransaction(AccountTransaction transaction) {

        System.out.println(transaction);
    }*/

    public static void addTransaction(AccountTransaction transaction) {
        /*transactionRepository.findMemberAccount(transaction.getMemberId());*/
        /*Optional<AccountTransaction> transactionById = transactionRepository.findMemberAccount(transaction.getMemberId());
        if (transactionById.isPresent()) {
            throw new IllegalStateException("No member found");
        }*/

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


}

