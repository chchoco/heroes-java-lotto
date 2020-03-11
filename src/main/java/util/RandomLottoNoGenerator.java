package util;

import model.LottoNo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static List<LottoNo> lottoNumbers = new ArrayList<>(LOTTO_SIZE);

    public static List<LottoNo> makeQuickPick() {
        lottoNumbers = makeAllNumbers().subList(0, LOTTO_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List makeAllNumbers() {
        List<LottoNo> allNumbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            allNumbers.add(new LottoNo(i));
        }
        Collections.shuffle(allNumbers);
        return allNumbers;
    }
}
