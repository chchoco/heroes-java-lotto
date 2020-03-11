package model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WinningLottoTest {
    WinningLotto winningLotto;

    @Before
    public void setUp() {
        List<LottoNo> winNumbers = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4),
                new LottoNo(5), new LottoNo(6));
        winningLotto = new WinningLotto(winNumbers);
    }

    @Test
    public void 여섯개숫자가일치할때() {
        List<LottoNo> firstLottoNo = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4),
                new LottoNo(5), new LottoNo(6));
        Lotto lotto = new Lotto(firstLottoNo);
        assertEquals(6, winningLotto.getSameNumberCount(lotto));
    }

    @Test
    public void 다섯개숫자가일치할때() {
        List<LottoNo> secondLottoNo = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4),
                new LottoNo(5), new LottoNo(45));
        Lotto lotto = new Lotto(secondLottoNo);
        assertEquals(5, winningLotto.getSameNumberCount(lotto));
    }

    @Test
    public void 네개숫자가일치할떄() {
        List<LottoNo> secondLottoNo = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4),
                new LottoNo(43), new LottoNo(44));
        Lotto lotto = new Lotto(secondLottoNo);
        assertEquals(4, winningLotto.getSameNumberCount(lotto));
    }

    @Test
    public void 세개숫자가일치할떄() {
        List<LottoNo> secondLottoNo = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(42),
                new LottoNo(44), new LottoNo(45));
        Lotto lotto = new Lotto(secondLottoNo);
        assertEquals(3, winningLotto.getSameNumberCount(lotto));
    }

    @Test
    public void 두개숫자가일치할때() {
        List<LottoNo> secondLottoNo = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(42), new LottoNo(43),
                new LottoNo(44), new LottoNo(45));
        Lotto lotto = new Lotto(secondLottoNo);
        assertEquals(2, winningLotto.getSameNumberCount(lotto));
    }

    @Test
    public void 하나숫자가일치할때() {
        List<LottoNo> secondLottoNo = Arrays.asList(new LottoNo(1), new LottoNo(41), new LottoNo(42), new LottoNo(43)
                , new LottoNo(44), new LottoNo(45));
        Lotto lotto = new Lotto(secondLottoNo);
        assertEquals(1, winningLotto.getSameNumberCount(lotto));
    }

    @Test
    public void 하나도일치하지않을때() {
        List<LottoNo> secondLottoNo = Arrays.asList(new LottoNo(40), new LottoNo(41), new LottoNo(42),
                new LottoNo(43), new LottoNo(44), new LottoNo(45));
        Lotto lotto = new Lotto(secondLottoNo);
        assertEquals(0, winningLotto.getSameNumberCount(lotto));
    }
}