package za.ac.nwu.ac.account_system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class AccountSystemApplicationTests {

    Calculator underTest = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        //given
        int numberOne = 20;
        int numberTwo = 30;

        //when
        int result = underTest.add(numberOne, numberTwo);
        int expected = 50;

        //then
        assertThat(result).isEqualTo(expected);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }
}
