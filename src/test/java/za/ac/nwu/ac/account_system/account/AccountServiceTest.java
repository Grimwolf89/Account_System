package za.ac.nwu.ac.account_system.account;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.nwu.ac.account_system.account.BusinessLogic.AccountService;
import za.ac.nwu.ac.account_system.account.DataAccess.AccountRepository;
import za.ac.nwu.ac.account_system.account.DataAccess.AccountTransaction;
import za.ac.nwu.ac.account_system.account.DataAccess.TransactionRepository;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@DataJpaTest
class AccountServiceTest {

    private AccountService underTest;
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private AccountRepository accountRepository;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new AccountService(accountRepository, transactionRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canAddTransaction() {

        //given
        Long memberId = 123L;
        AccountTransaction transaction = new AccountTransaction(
                1L,
                memberId,
                50L,
                LocalDate.of(2021, Month.SEPTEMBER, 28)
        );

        //when
        underTest.addTransaction(transaction);

        //then
        ArgumentCaptor<AccountTransaction> transactionCaptor =
                ArgumentCaptor.forClass(AccountTransaction.class);

        verify(transactionRepository).save(transactionCaptor.capture());

        AccountTransaction captureTransaction =  transactionCaptor.getValue();
        
        assertThat(captureTransaction).isEqualTo(transaction);
    }

    @Test
    void canSubtractTransaction() {
        //given
        Long memberId = 123L;
        AccountTransaction transaction = new AccountTransaction(
                1L,
                memberId,
                50L,
                LocalDate.of(2021, Month.SEPTEMBER, 28)
        );

        //when
        underTest.subtractTransaction(transaction);

        //then
        ArgumentCaptor<AccountTransaction> transactionCaptor =
                ArgumentCaptor.forClass(AccountTransaction.class);

        verify(transactionRepository).save(transactionCaptor.capture());

        AccountTransaction captureTransaction =  transactionCaptor.getValue();

        assertThat(captureTransaction).isEqualTo(transaction);
    }

    @Test
    void canShowAllAccounts() {
        //when
        underTest.showAccounts();
        //then
        verify(accountRepository).findAll();
    }

    @Test
    void canShowAllTransactions() {
        //when
        underTest.showTransactions();
        //then
        verify(transactionRepository).findAll();
    }

    @Test
    void findByMemberAccount() {
        //given
        Long memberId = 123L;
        //when
        underTest.findByMemberAccount(memberId);
        //then
        verify(transactionRepository).findByMemberId(memberId);
    }

    @Test
    void canViewMemberMiles() {
        //when
        String findResult = underTest.viewMemberMiles(123L);
        String expectedValue = "The miles for Member: 123 is 0 Miles ";
        //then
        assertThat(findResult).isEqualTo(expectedValue);
    }
}