package util;

import model.LottoNo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RandomLottoNoGeneratorTest {
    private static final int LOTTO_SIZE = 6;

    @Test
    public void 자동로또숫자6개를_만든다() {
        List<LottoNo> lottoNumbers;
        lottoNumbers = RandomLottoNoGenerator.makeQuickPick();
        assertEquals(lottoNumbers.size(), LOTTO_SIZE);
    }
}