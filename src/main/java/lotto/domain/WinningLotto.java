package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class WinningLotto {
    private final Lotto winning;
    private final Bonus bonus;

    public WinningLotto(Lotto winning, Bonus bonus) {
        validate(winning, bonus);
        this.winning = winning;
        this.bonus = bonus;
    }

    private static void validate(Lotto winning, Bonus bonus) {
        List<Integer> numbers = winning.getNumbers();
        int bonusNum = bonus.getBonus();
        if (numbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    public LottosRankResult evaluate(Lottos lottos) {
        Map<Rank, Long> resultMap = new EnumMap<>(Rank.class);
        List<Lotto> list = lottos.getLottos();
        for (Lotto lotto : list) {
            int matchCount = lotto.matchCountWith(winning);
            boolean bonusMatched = lotto.contains(bonus.getBonus());
            Rank rank = Rank.of(matchCount, bonusMatched);
            resultMap.merge(rank, 1L, Long::sum);
        }
        return new LottosRankResult(resultMap);
    }
}
