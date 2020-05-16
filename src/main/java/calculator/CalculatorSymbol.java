package calculator;

public class CalculatorSymbol {
    private int add(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    private int subtract(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    private int multiply(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    private int division(int firstNum, int secondNum) {
        if (secondNum == 0) {
            throw new ArithmeticException("분모가 0일수 없습니다.");
        }
        return firstNum / secondNum;
    }

    public int findTypeAndCalculator(int firstNum, int secondNum, String symbol) {
        int result = 0;
        switch (symbol) {
            case "+":
                result = add(firstNum, secondNum);
                break;
            case "-":
                result = subtract(firstNum, secondNum);
                break;
            case "*":
                result = multiply(firstNum, secondNum);
                break;
            case "/":
                result = division(firstNum, secondNum);
                break;
            default:
                throw new IllegalArgumentException("calculatorsymbol is error");

        }
        return result;
    }

}
