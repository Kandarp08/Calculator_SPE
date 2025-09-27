package org.calculator;

import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        Scanner scan = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("Calculator Menu:");
        System.out.println("1. Square root");
        System.out.println("2. Factorial");
        System.out.println("3. Natural Logarithm");
        System.out.println("4. Power");
        System.out.println("5. Exit");
        System.out.println("--------------------");

        while (true)
        {
            System.out.print("Enter your choice: ");
            int opt = scan.nextInt();

            try
            {
                if (opt == 1)
                {
                    System.out.print("Enter an integer: ");
                    int x = scan.nextInt();

                    System.out.println("Square root = " + calculator.squareRoot(x));
                }

                else if (opt == 2)
                {
                    System.out.print("Enter an integer: ");
                    int x = scan.nextInt();

                    System.out.println("Factorial = " + calculator.factorial(x));
                }

                else if (opt == 3)
                {
                    System.out.print("Enter an integer: ");
                    int x = scan.nextInt();

                    System.out.println("Natural Logarithm = " + calculator.naturalLogarithm(x));
                }

                else if (opt == 4)
                {
                    System.out.print("Enter base (integer): ");
                    int x = scan.nextInt();
                    System.out.print("Enter exponent (integer): ");
                    int y = scan.nextInt();

                    System.out.println("Power = " + calculator.power(x, y));
                }

                else if (opt == 5)
                {
                    System.out.println("Thank you for using the calculator!");
                    break;
                }

                else
                    System.out.println("Invalid option chosen.");

                System.out.println();
            }

            catch(ArithmeticException e)
            {
                System.out.println("Exception in calculator:");
                System.out.println(e.getMessage());
            }

            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        scan.close();
    }
}
