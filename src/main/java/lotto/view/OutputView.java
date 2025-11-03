package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottosRankResult;
import lotto.domain.Rank;
import lotto.parser.OutputParser;

public class OutputView {
    public void outputRandomLottos(Lottos lottos, int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
        List<Lotto> printLottos = lottos.getLottos();
        printLottos.stream().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void outputResult(LottosRankResult lottosRankResult, int lottoPurchaseAmount) {
        System.out.println("\n당첨 통계\n---");
        printLottoResult(lottosRankResult);
        printReturnRate(lottosRankResult, lottoPurchaseAmount);
    }

    private void printLottoResult(LottosRankResult r) {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.KOREA);
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) {
                continue;
            }
            printRankLine(rank, r.countOf(rank), nf);
        }
    }

    private void printRankLine(Rank rank, long count, NumberFormat nf) {
        String prize = nf.format(rank.getPrize());
        if (rank == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                    rank.getMatchCount(), prize, count);
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개%n",
                rank.getMatchCount(), prize, count);
    }

    private void printReturnRate(LottosRankResult lottosRankResult, int lottoPurchaseAmount) {
        long totalAmount = lottosRankResult.returnTotalPrize();
        double returnRate = (double) totalAmount / lottoPurchaseAmount * 100;
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", returnRate));
    }

}
