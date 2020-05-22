package edu.ti.caih313.collections.lambda;

public class Calculator {
    public static void main(String... args) {

        Calculator myApp = new Calculator();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        IntegerMath multiplication = (a, b) -> a * b;
        IntegerMath division = (a, b) -> a / b;
        DoubleMath doubleAdd = (a, b) -> a + b;
        DoubleMath doubleMinus = (a, b) -> a - b;
        DoubleMath doubleTimes = (a, b) -> a * b;
        DoubleMath doubleDivide = (a, b) -> a / b;
        UnaryDoubleMath abs = (a) -> a > 0? a: a * -1;
        UnaryDoubleMath invert = (a) -> 1 / a;
        System.out.println("40 + 2 = " +
            myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
            myApp.operateBinary(20, 10, subtraction));
        System.out.println("2 * 3 = " +
                myApp.operateBinary(2, 3, multiplication));
        System.out.println("2 / 2 = " + myApp.operateBinary(2, 2, division));//TODO the /
        System.out.println("1.1 + 1.1 = " + myApp.doubleOperate(1.1, 1.1, doubleAdd));
        System.out.println("2.2 - 1.1 = " + myApp.doubleOperate(2.2, 1.1, doubleMinus));
        System.out.println("2.2 * 3 = " + myApp.doubleOperate(2.2, 3, doubleTimes));
        System.out.println("2.2 / 1 = " + myApp.doubleOperate(2.2, 1, doubleDivide));
        System.out.println("|-1| = " + myApp.unary(-1, abs));//TODO read up
        System.out.println("|1| = " + myApp.unary(1, abs));
        System.out.println("inverse of 2 = " + myApp.unary(2, invert));
    }

    private int operateBinary(int a, int b, IntegerMath integerMath) {
        return integerMath.operation(a, b);
    }
    private double doubleOperate(double a, double b, DoubleMath doubleMath){
        return doubleMath.operation(a, b);
    }
    //TODO change variable names
    private double unary(double a, UnaryDoubleMath unaryDoubleMath){
        return unaryDoubleMath.operation(a);
    }
}
