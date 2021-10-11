package za.ac.nwu.ac.account_system.account.DataAccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "Account_Transaction")
public class AccountTransaction implements Serializable {

    private static  final Logger LOGGER = LoggerFactory.getLogger(AccountTransaction.class);

    private Long transactionId;
//    private AccountType accountType;
    private Long accountTypeId;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction(Long transactionId, Long accountType, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
//        this.accountType = accountType;
        this.accountTypeId = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;



    }

    public AccountTransaction(Long accountType, Long memberId, Long amount, LocalDate transactionDate) {
//        this.accountType = accountType;
        this.accountTypeId = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;

        LOGGER.info("A transaction was created with the following details: {}", this.toString());
    }

    public AccountTransaction() {

    }

    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    @Column(name = "TX_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name ="ACCOUNT_TYPE_ID")
    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountType() {
        return accountTypeId;
    }

    public void setAccountType(Long accountType) {
        this.accountTypeId = accountType;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "TX_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountTypeId, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountTypeId=" + accountTypeId +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }



}
