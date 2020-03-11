package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoNoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 범위에벗어나는_숫자를_넣는다() {
        LottoNo lotto1 = new LottoNo(0);
        LottoNo lotto2 = new LottoNo(46);
        LottoNo lotto3 = new LottoNo(-1);
    }

    @Test
    public void 범위안의_숫자를_넣는다() {
        for (int i = 1; i <= 45; i++) {
            LottoNo lottoNo = new LottoNo(i);
            assertTrue(lottoNo.equals(new LottoNo(i)));
        }
    }
}