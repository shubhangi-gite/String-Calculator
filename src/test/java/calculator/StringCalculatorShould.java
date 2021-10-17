package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {


    @Test
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(stringCalculator.add("1"), 1);
        assertEquals(stringCalculator.add("5"), 5);
    }

    @Test
    public void numbers_Comma_Delimited_Should_Be_Summed() {
    	 StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("1,2"), 3);
        assertEquals(25, stringCalculator.add("10,15"));
    }

    @Test
    public void numbers_Newline_Delimited_Should_Be_Summed() {
    	 StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("1\n2"), 3);
        assertEquals(stringCalculator.add("11\n13"), 24);
    }

    @Test
    public void three_Numbers_Delimited_Anyway_Should_Be_Summed() {
    	 StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("1,2,3"), 6);
        assertEquals(stringCalculator.add("5\n2\n3"), 10);
    }

    @Test
    public void numbers_Greater_Than_1000_Are_Ignored() {
    	 StringCalculator stringCalculator = new StringCalculator();
        assertEquals(stringCalculator.add("5,12,1001"), 17);
        assertEquals(stringCalculator.add("14124,22\n4,1214"), 26);
    }
    
    @Test
    public void test_Negative_Number() {
    	 StringCalculator stringCalculator = new StringCalculator();
        try {
            stringCalculator.add("-1,2");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negatives not allowed");
        }
        try {
            stringCalculator.add("1,-2,3,-5");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negatives not allowed");
        }
    }
    
}
