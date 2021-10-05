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

    /*public List<AccountTransaction> showTransactionById(Long id) {
        return transactionRepository.findByMemberAccount(id);
    }*/


    public List<AccountTransaction> findByMemberAccount(Long id) {
        return transactionRepository.findByMemberId(id);
    }

    public String viewMemberMiles(Long id) {
        List<AccountTransaction> accountTransactionList = findByMemberAccount(id);
        Long availableMiles = 0L;

        for (int i = 0; i < accountTransactionList.size(); i++) {
            availableMiles += accountTransactionList.get(i).getAmount();
        }
        System.out.println("The miles for Member: "+ id.toString() + " is " +  availableMiles + " Miles ");
        return "The miles for Member: "+ id.toString() + " is " +  availableMiles + " Miles ";
    }
}

