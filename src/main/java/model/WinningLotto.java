package model;

import java.util.List;

public class WinningLotto extends Lotto {
    private List<LottoNo> winningNumbers;

    public WinningLotto(List<LottoNo> winningNumbers) {
        super(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public int getSameNumberCount(Lotto lotto) {
        int sameNumberCount = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            sameNumberCount += addSameNumberCount(lotto, winningNumbers.get(i));
        }
        return sameNumberCount;
    }

    private int addSameNumberCount(Lotto lotto, LottoNo no) {
        int count = 0;
        if (lotto.hasNumber(no)) {
            count++;
        }
        return count;
    }
}
