package org.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest
{
    private final Calculator calculator = new Calculator();

    @Test
    void testSquareRoot()
    {
        assertThrows(ArithmeticException.class, () -> {
            calculator.squareRoot(-10);
        });

        assertEquals(0, calculator.squareRoot(0));
        assertEquals(3.605551275463989, calculator.squareRoot(13));
    }

    @Test
    void testFactorial()
    {
        assertThrows(ArithmeticException.class, () -> {
            calculator.factorial(-5);
        });

        assertEquals(1, calculator.factorial(0));
        assertEquals(5040, calculator.factorial(7));
    }

    @Test
    void testNaturalLogarithm()
    {
        assertThrows(ArithmeticException.class, () -> {
            calculator.naturalLogarithm(0);
        });

        assertThrows(ArithmeticException.class, () -> {
            calculator.naturalLogarithm(-2);
        });

        assertEquals(0, calculator.naturalLogarithm(1));
        assertEquals(3.6888794541139363, calculator.naturalLogarithm(40));
    }

    @Test
    void testPower()
    {
        assertEquals(0.2, calculator.power(5, -1));
        assertEquals(0.015625, calculator.power(4, -3));
        assertEquals(16, calculator.power(2, 4));
        assertEquals(0.00015241579027587258, calculator.power(-3, -8));
    }
}
