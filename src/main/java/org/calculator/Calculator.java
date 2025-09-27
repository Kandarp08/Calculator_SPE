package org.calculator;

public class Calculator
{
    public Calculator()
    {

    }

    public double squareRoot(int x) throws ArithmeticException
    {
        if (x < 0)
            throw new ArithmeticException("Square root of negative number cannot be taken.");

        return Math.sqrt(x);
    }

    public long factorial(int x) throws ArithmeticException
    {
        if (x < 0)
            throw new ArithmeticException("Factorial of negative number cannot be taken.");

        if (x == 0)
            return 1;

        long fact = 1;

        for (int i = 1; i <= x; ++i)
            fact *= i;

        return fact;
    }

    public double naturalLogarithm(int x) throws ArithmeticException
    {
        if (x <= 0)
            throw new ArithmeticException("Natural logarithm of non-positive number cannot be taken.");

        return Math.log(x);
    }

    public double power(int x, int y)
    {
        return Math.pow(x, y);
    }
}
