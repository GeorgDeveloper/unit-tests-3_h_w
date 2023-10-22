package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    // 3.1.

    SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }


    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12})
    void multipleThreeNotFiveReturnsFizz(int input) {
        String actual = someService.fizzBuzz(input);

        assertThat(actual).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25})
    void multipleThreeNotFiveReturnsBuzz(int input) {
        String actual = someService.fizzBuzz(input);

        assertThat(actual).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60})
    void multipleThreeNotFiveReturnsFizzBuzz(int input) {
        String actual = someService.fizzBuzz(input);

        assertThat(actual).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {17, 31, 47, 61})
    void multipleThreeNotFiveReturnsValue(int input) {
        String actual = someService.fizzBuzz(input);

        assertThat(actual).isEqualTo(String.valueOf(input));
    }

    @Test
    void checkEmptyArray() {
        boolean actual = someService.firstLast6(new int[]{});
        assertFalse(actual);
    }

    @Test
    void checkWithout6Array() {
        boolean actual = someService.firstLast6(new int[]{0, 0, 0});
        assertFalse(actual);
    }


    @Test
    void checkFirst6Array() {
        boolean actual = someService.firstLast6(new int[]{6, 0, 0});
        assertTrue(actual);
    }

    @Test
    void checkLast6Array() {
        boolean actual = someService.firstLast6(new int[]{0, 0, 6});
        assertTrue(actual);
    }

    @Test
    void checkMidle6Array() {
        boolean actual = someService.firstLast6(new int[]{0, 6, 0});
        assertFalse(actual);
    }

    @Test
    void checkFirstAndLast6Array() {
        boolean actual = someService.firstLast6(new int[]{6, 0, 6});
        assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"10 ,50", "200, 50", "1000, 30"})
    void calculatingDiscountPositive(double purchase, int discount) {

        double actual = someService.calculatingDiscount(purchase, discount);
        assertThat(actual).isEqualTo(purchase - purchase * discount / 100);
    }

    @ParameterizedTest
    @CsvSource(value = {"-10 ,50", "-200, 50", "-1000, 30"})
    void calculatingDiscountNegative(double purchase, int discount) {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> someService.calculatingDiscount(purchase, discount));
assertEquals(ex.getMessage(), "purchaseAmount < 0");

    }

    @ParameterizedTest
    @CsvSource(value = {"10 ,150", "200, 150", "1000, 130"})
    void calculatingDiscountBigDiscountNegative(double purchase, int discount) {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> someService.calculatingDiscount(purchase, discount));
        assertEquals(ex.getMessage(), "discountAmount > 100");
    }

    @ParameterizedTest
    @CsvSource(value = {"10 ,-150", "200, -150", "1000, -130"})
    void calculatingDiscountSmallDiscountNegative(double purchase, int discount) {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> someService.calculatingDiscount(purchase, discount));
        assertEquals(ex.getMessage(), "discountAmount < 0");
    }



    @Test
    void calculatingSumThreeNumbersTest(){
        int actual = someService.calculatingSumThreeNumbers(1,2,3);
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void calculatingSumThreeNumbersTestTwo(){
        assertThat(someService.calculatingSumThreeNumbers(13,2,3)).isEqualTo(5);
        assertThat(someService.calculatingSumThreeNumbers(1,13,3)).isEqualTo(4);
        assertThat(someService.calculatingSumThreeNumbers(1,2,13)).isEqualTo(3);
    }

}