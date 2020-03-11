package model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 숫자6개를_초과하는로또를만든다() {
        List<LottoNo> testLotto = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(23),
                new LottoNo(26), new LottoNo(41), new LottoNo(11));
        Lotto lotto = new Lotto(testLotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자6개_미만의로또를만든다() {
        List<LottoNo> testLotto = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(23),
                new LottoNo(11));
        Lotto lotto = new Lotto(testLotto);
    }

    @Test
    public void 숫자6개의_로또를만든다() {
        List<LottoNo> testLotto = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(23),
                new LottoNo(19), new LottoNo(41));
        Lotto lotto = new Lotto(testLotto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복된번호의_로또를_만든다() {
        List<LottoNo> testLotto = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(23),
                new LottoNo(23), new LottoNo(41));
        Lotto lotto = new Lotto(testLotto);
    }

    @Test
    public void 숫자의포함여부를확인한다() {
        List<LottoNo> test = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(23),
                new LottoNo(33), new LottoNo(41));
        Lotto testlotto = new Lotto(test);
        assertTrue(testlotto.hasNumber(new LottoNo(1)));
        assertFalse(testlotto.hasNumber(new LottoNo(9)));
    }
}