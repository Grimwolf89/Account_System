package za.ac.nwu.ac.account_system.account;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "Account_Transaction")
public class AccountTransaction implements Serializable {


    private Long transactionId;
    private AccountType accountType;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountTransaction(Long transactionId, AccountType accountType, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction(AccountType accountType, Long memberId, Long amount, LocalDate transactionDate) {
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TX_ID")
    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
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
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountType, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "transactionId=" + transactionId +
                ", accountTypeId=" + accountType +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
