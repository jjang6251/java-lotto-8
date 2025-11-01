package lotto;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottosRankResult;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.factory.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottosRankResultTest {
    @DisplayName("로또들에 대한 당첨 결과가 나온다")
    @Test
    void 로또들에_대한_당첨_결과가_나온다() {
        Lotto miss = LottoFactory.make(List.of(1, 2, 3, 4, 5, 6));
        Lotto rankFirst = LottoFactory.make(List.of(43, 17, 5, 2, 13, 19));
        Lotto rankSecond = LottoFactory.make(List.of(43, 17, 5, 2, 3, 19));
        Lotto rankThird = LottoFactory.make(List.of(43, 17, 5, 2, 12, 19));
        Lotto winningNum = LottoFactory.make(List.of(43, 17, 5, 2, 13, 19));
        Bonus bonus = new Bonus(3);
        Lottos lottos = new Lottos(List.of(miss, rankFirst, rankSecond, rankThird));
        WinningLotto winningLotto = new WinningLotto(winningNum, bonus);

        LottosRankResult lottosRankResult = winningLotto.evaluate(lottos);

        assertThat(lottosRankResult.countOf(Rank.FIRST)).isEqualTo(1);
        assertThat(lottosRankResult.countOf(Rank.SECOND)).isEqualTo(1);
        assertThat(lottosRankResult.countOf(Rank.THIRD)).isEqualTo(1);
        assertThat(lottosRankResult.countOf(Rank.FOURTH)).isEqualTo(0);
        assertThat(lottosRankResult.countOf(Rank.FIFTH)).isEqualTo(0);
        assertThat(lottosRankResult.countOf(Rank.MISS)).isEqualTo(1);
    }

    @DisplayName("로또들에 대한 총상금이 반환된다.")
    @Test
    void 로또들에_대한_총상금이_반환된다() {
        Lotto miss = LottoFactory.make(List.of(1, 2, 3, 4, 5, 6));
        Lotto rankFirst = LottoFactory.make(List.of(43, 17, 5, 2, 13, 19));
        Lotto rankSecond = LottoFactory.make(List.of(43, 17, 5, 2, 3, 19));
        Lotto rankThird = LottoFactory.make(List.of(43, 17, 5, 2, 12, 19));
        Lotto winningNum = LottoFactory.make(List.of(43, 17, 5, 2, 13, 19));
        Bonus bonus = new Bonus(3);
        Lottos lottos = new Lottos(List.of(miss, rankFirst, rankSecond, rankThird));
        WinningLotto winningLotto = new WinningLotto(winningNum, bonus);

        LottosRankResult lottosRankResult = winningLotto.evaluate(lottos);

        assertThat(lottosRankResult.returnTotalPrize()).isEqualTo(2_031_500_000);
    }
}
