package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.factory.LottosFactory;
import lotto.parser.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 번호가 1~45 범위 안에 없으면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위_안에_없으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액 만큼 로또가 생성된다.")
    @Test
    void 입력된_금액_만큼_로또가_생성된다() {
        InputParser inputParser = new InputParser();
        int count = inputParser.purchaseAmountInputParser("8000");
        Lottos lottos = LottosFactory.buy(count);
        List<Lotto> list = lottos.getLottos();
        list.stream().count();

        assertThat(list.stream().count()).isEqualTo(count);
    }
}
