package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {

    MoodAnalyser moodAnalyser;
    @BeforeEach
    void setUp(){
        moodAnalyser = new MoodAnalyser();
    }
    //3.5. Red-Green-Refactor
    @ParameterizedTest
    @ValueSource(strings = {"Hi", "Hello", "Ok"})
    void GoodMoodTest(String input){
        String actual = moodAnalyser.analyseMood(input);
        assertThat(actual).isEqualTo("Great");
    }

    @ParameterizedTest
    @ValueSource(strings = {"By", "Sad", "Bad"})
    void BadMoodTest(String input){
        String actual = moodAnalyser.analyseMood(input);
        assertThat(actual).isEqualTo("Bad");
    }

    @ParameterizedTest
    @ValueSource(strings = {"B", "Sa", "Ba"})
    void UnknowMoodTest(String input){
        String actual = moodAnalyser.analyseMood(input);
        assertThat(actual).isEqualTo("I dont know");
    }
}