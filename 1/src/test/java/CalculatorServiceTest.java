import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    private CalculatorService calculatorService;
    @BeforeEach
    void beforeEach() {
        calculatorService = new CalculatorService();
    }
    @Test
    void shouldAddTwoCorrectNumbers() {
// given
        String a = "10";
        String b = "20";
// when
        int result = calculatorService.add(a, b);
// then
        assertEquals(30, result);
    }

    @Test
    void shouldRoundFirstDecimalNumberAndAddNumbers() {
// given
        String a = "10.1";
        String b = "20";
// when
        int result = calculatorService.add(a, b);
// then
        assertEquals(30, result);
    }

    @Test
    void shouldRoundSecondDecimalNumberAndAddNumbers() {
// given
        String a = "10";
        String b = "20.1";
// when
        int result = calculatorService.add(a, b);
// then
        assertEquals(30, result);
    }

    @Test
    void shouldThrowExceptionOnInvalidFirstArgument() {
// given
        String a = "wrong-number";
        String b = "10";
// when
        Throwable throwable = catchThrowable(() -> calculatorService.add(a, b));
// then
        assertThat(throwable)
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: \"wrong-number\"");
    }

    @Test
    void shouldThrowExceptionOnInvalidSecondArgument() {
// given
        String a = "10";
        String b = "wrong-number";
// when
        Throwable throwable = catchThrowable(() -> calculatorService.add(a, b));
// then
        assertThat(throwable)
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: \"wrong-number\"");
    }

    @Test
    void shouldThrowExceptionOnInvalidTwoArguments() {
// given
        String a = "wrong-number";
        String b = "wrong-number";
// when
        Throwable throwable = catchThrowable(() -> calculatorService.add(a, b));
// then
        assertThat(throwable)
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("For input string: \"wrong-number\"");
    }

    @Test
    void shouldThrowExceptionOnEmptyFirstArgument() {
// given
        String a = "";
        String b = "5";
// when
        Throwable throwable = catchThrowable(() -> calculatorService.add(a, b));
// then
        assertThat(throwable)
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("empty String");
    }

    @Test
    void shouldThrowExceptionOnEmptySecondArgument() {
// given
        String a = "15";
        String b = "";
// when
        Throwable throwable = catchThrowable(() -> calculatorService.add(a, b));
// then
        assertThat(throwable)
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("empty String");
    }

    @Test
    void shouldThrowExceptionOnEmptyTwoArguments() {
// given
        String a = "";
        String b = "";
// when
        Throwable throwable = catchThrowable(() -> calculatorService.add(a, b));
// then
        assertThat(throwable)
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("empty String");
    }

    @Test
    void shouldThrowExceptionOnIntegerOverFlow() {
// given
        String a = Integer.MAX_VALUE + "";
        String b = "11";
// when
        Throwable throwable = catchThrowable(() -> calculatorService.add(a, b));
// then
        assertThat(throwable)
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("integer overflow");
    }
}