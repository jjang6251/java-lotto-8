package lotto.factory;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottosFactory {
    public static Lottos buy(int count) {
        List<Lotto> list = IntStream.range(0, count)
                .mapToObj(i -> LottoFactory.random())
                .toList();
        return new Lottos(List.copyOf(list));
    }
}
