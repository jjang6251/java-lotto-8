package lotto.domain;

import java.util.Map;

public class LottosRankResult {
    private final Map<Rank, Long> resultMap;

    public LottosRankResult(Map<Rank, Long> resultMap) {
        this.resultMap = resultMap;
    }

    public long countOf(Rank rank) {
        return resultMap.getOrDefault(rank, 0L);
    }

    public long returnTotalPrize() {
        return resultMap.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
