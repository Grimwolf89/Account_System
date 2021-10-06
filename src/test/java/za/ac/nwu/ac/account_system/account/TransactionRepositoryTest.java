package za.ac.nwu.ac.account_system.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository underTest;


    @Test()
    void itShouldfindByMemberId() {

        // given
        Long memberId = 123L;
        AccountTransaction transaction = new AccountTransaction(
                1L,
                memberId,
                50L,
                LocalDate.of(2021, Month.SEPTEMBER, 28)
        );
        underTest.save(transaction);

        //when
        boolean expectedValue = underTest.selectExistingMember(transaction.getMemberId());


        //then
        assertThat(expectedValue).isTrue();
    }
}