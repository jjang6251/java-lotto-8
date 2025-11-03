package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.LottosRankResult;
import lotto.domain.WinningLotto;
import lotto.factory.LottoFactory;
import lotto.factory.LottosFactory;
import lotto.parser.InputParser;
import lotto.parser.OutputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private static final int LOTTO_PRICE = 1_000;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int lottoPurchaseAmount = inputView.inputLottoPurchaseAmount();
        int lottoCount = lottoPurchaseAmount/LOTTO_PRICE;
        Lottos lottos = LottosFactory.buy(lottoCount);
        outputView.outputRandomLottos(lottos, lottoCount);

        List<Integer> winningNums = inputView.inputWinningNums();
        Lotto winningLotto = LottoFactory.make(winningNums);
        int bonus = inputView.inputBonusNum();
        Bonus bonusNum = new Bonus(bonus);
        WinningLotto makeWinningLotto = new WinningLotto(winningLotto, bonusNum);

        LottosRankResult lottosRankResult = makeWinningLotto.evaluate(lottos);
        outputView.outputResult(lottosRankResult, lottoPurchaseAmount);
    }
}
