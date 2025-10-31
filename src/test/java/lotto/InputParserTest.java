package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.parser.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    @DisplayName("쉼표(,) 이외의 구분자 작성시 예외가 발생한다")
    @Test
    void 쉼표_이외의_구분자_작성시_예외가_발생한다() {
        InputParser inputParser = new InputParser();
        assertThatThrownBy(() -> inputParser.winningNumInputParser("1.2.3.4.5.6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자가 아닌 문자가 오면 예외가 발생한다")
    @Test
    void 로또_번호에_숫자가_아닌_문자가_오면_예외가_발생한다() {
        InputParser inputParser = new InputParser();
        assertThatThrownBy(() -> inputParser.winningNumInputParser("a,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 1000원 단위가 아닐 경우 예외가 발생한다")
    @Test
    void 입력_금액이_1000원_단위가_아닐_경우_예외가_발생한다() {
        InputParser inputParser = new InputParser();
        assertThatThrownBy(() -> inputParser.purchaseAmountInputParser("14100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액에 음수 또는 0을 입력했을 경우")
    @Test
    void 입력_금액이_음수_또는_0을_입력했을_경우_예외가_발생한다() {
        InputParser inputParser = new InputParser();
        assertThatThrownBy(() -> inputParser.purchaseAmountInputParser("-100"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputParser.purchaseAmountInputParser("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액에 금액을 입력하지 않을 경우 예외가 발생한다")
    @Test
    void 입력_금액에_금액을_입력하지_않을_경우_예외가_발생한다() {
        InputParser inputParser = new InputParser();
        assertThatThrownBy(() -> inputParser.purchaseAmountInputParser(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputParser.purchaseAmountInputParser(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 1000만원 이상일 경우 예외가 발생한다")
    @Test
    void 입력_금액이_1000만원_이상일_경우_예외가_발생한다() {
        InputParser inputParser = new InputParser();
        assertThatThrownBy(() -> inputParser.purchaseAmountInputParser("10000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액이 숫자가 아닐 경우 예외가 발생한다")
    @Test
    void 입력_금액이_숫자가_아닐_경우_예외가_발생한다() {
        InputParser inputParser = new InputParser();
        assertThatThrownBy(() -> inputParser.purchaseAmountInputParser("AA"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
