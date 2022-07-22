package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public double divide(int y) {
        return (double) y / x;
    }

    public double sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        int resultSum = sum(10);
        System.out.println(resultSum);
        int resultMinus = minus(83);
        System.out.println(resultMinus);
        Calculator calculator = new Calculator();
        int resultMultiple = calculator.multiply(5);
        System.out.println(resultMultiple);
        double resultDivide = calculator.divide(37);
        System.out.println(resultDivide);
        double resultAll = calculator.sumAllOperation(7);
        System.out.println(resultAll);
    }
}
