package lotto.domain;

import java.util.List;

public final class WinningNum {
    private final Lotto winning;
    private final Bonus bonus;

    public WinningNum(Lotto winning, Bonus bonus) {
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
}
