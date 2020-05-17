package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorSymbolTest {

    private CalculatorSymbol calculatorSymbol;
    private int firstNum = 4;
    private int secondNum = 2;

    @BeforeEach
    void setUp() {
        calculatorSymbol = new CalculatorSymbol();
    }

    @DisplayName("더하기 테스트")
    @Test
    void findTypeAndAdd() {

        int result = calculatorSymbol.findTypeAndCalculator(firstNum, secondNum, "+");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("빼기 테스트")
    @Test
    void findTypeAndSubtract() {

        int result = calculatorSymbol.findTypeAndCalculator(firstNum, secondNum, "-");
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void findTypeAndDivision() {

        int result = calculatorSymbol.findTypeAndCalculator(firstNum, secondNum, "/");
        assertThat(result).isEqualTo(2);

    }

    @DisplayName("곱셈 테스트")
    @Test
    void findTypeAndMultiply() {

        int result = calculatorSymbol.findTypeAndCalculator(firstNum, secondNum, "*");
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("잘못된 계산식 테스트")
    @ParameterizedTest
    @MethodSource
    void findTypeAndErrorInput(int firstNum, int secondNum, String symbol) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculatorSymbol.findTypeAndCalculator(firstNum, secondNum, symbol));
    }

    private static Stream<Arguments> findTypeAndErrorInput() {
        return Stream.of(
                Arguments.of(8, 4, ")"),
                Arguments.of(4, 0, "/")
        );
    }
}