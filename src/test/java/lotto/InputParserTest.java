package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
