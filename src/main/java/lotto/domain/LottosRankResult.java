package lotto.domain;

import java.util.Map;

public class LottosRankResult {
    private final Map<Rank, Long> winningResult;

    public LottosRankResult(Map<Rank, Long> resultMap) {
        this.winningResult = resultMap;
    }

    public long countOf(Rank rank) {
        return winningResult.getOrDefault(rank, 0L);
    }

    public long returnTotalPrize() {
        return winningResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
