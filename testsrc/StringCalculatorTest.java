import com.kata.calculator.StringCalculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;

/**
 * Created by sterui on 1/23/17.
 */


public class StringCalculatorTest {

    @Mock
    StringCalculator stringCalculator;

    @Before
    public void setUp() {

        stringCalculator = new StringCalculator();
    }

    @Test
    public void shouldEmptyStringReturnZero() throws Exception {

        assertEquals(stringCalculator.calculate(""),0);
    }

    @Test
    public void shouldSingleNumberReturnItsValue() throws Exception {

        assertEquals(stringCalculator.calculate("15"),15);
    }

    @Test
    public void shouldTwoNumbersCommaDelimitedReturnSum() throws Exception {

        assertEquals(stringCalculator.calculate("15,10"),25);
    }

    @Test
    public void shouldTwoNumbersNewLineDelimitedReturnSum() throws Exception {

        assertEquals(stringCalculator.calculate("25\n20"),45);
    }

    @Test
    public void shouldThreeNumbersDelimitedReturnSum() throws Exception {

        assertEquals(stringCalculator.calculate("25\n20,50"),95);
    }

    @Test (expected = Exception.class)
    public void shouldNegativeNumbersThrowException() throws Exception {

        stringCalculator.calculate("25\n20,-50");
    }

    @Test
    public void shouldIgnoreNumbersGreaterThanOneK() throws Exception {

        assertEquals(stringCalculator.calculate("25\n20,1050"),45);
    }

    @Test
    public void shouldSingleCharDelimiterBeDefined() throws Exception {

        assertEquals(stringCalculator.calculate("//#\n25\n20,1050#22"),67);
    }

    @Test
    public void shouldMultipleCharDelimiterBeDefined() throws Exception {

        assertEquals(stringCalculator.calculate("//[###]\n25\n20,1050###22"),67);
    }
}
