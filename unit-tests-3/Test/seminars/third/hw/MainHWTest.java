package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MainHWTest {
    MainHW mainHW;

    @BeforeEach
    void setUp(){
        mainHW = new MainHW();
    }

    @Test
    void evenOddNumberPositiveTest(){
        assertTrue(mainHW.evenOddNumber(2));
    }

    @Test
    void evenOddNumberNegativeTest(){
        assertFalse(mainHW.evenOddNumber(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {28, 47, 61, 99})
    void numberInIntervalTestPositive(int input){
        assertTrue(mainHW.numberInInterval(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 25, 100, 1000})
    void numberInIntervalTestNegative(int input){
        assertFalse(mainHW.numberInInterval(input));
    }
}
