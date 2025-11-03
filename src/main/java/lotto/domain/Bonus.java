package lotto.domain;

public class Bonus {
    private final int bonus;

    public Bonus(int bonus) {
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 한다.");
        }
    }

    public int getBonus() {
        return bonus;
    }
}
