package model;

import dto.LottoGameResultDTO;
import org.junit.Before;
import org.junit.Test;
import util.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoGameTest {
    WinningLotto winningLotto;

    @Before
    public void setUp() {
        List<LottoNo> winNumbers = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4),
                new LottoNo(5), new LottoNo(6));
        winningLotto = new WinningLotto(winNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 돈을적게넣을경우() {
        List<String> slipLottos = new ArrayList<>();
        slipLottos.add("1,2,3,4,5,9");
        slipLottos.add("1,2,3,43,44,45");
        LottoGame lottoGame = new LottoGame(1000, slipLottos);
        LottoGame lottoGame2 = new LottoGame(500, slipLottos);

        List<String> slipLottos2 = new ArrayList<>();
        LottoGame lottoGame3 = new LottoGame(500, slipLottos2);
    }

    @Test
    public void 로또가_알맞은개수로_생성되었는지_확인한다() {
        List<String> slipLottos = new ArrayList<>();
        slipLottos.add("1,2,3,4,5,9");
        slipLottos.add("1,2,3,43,44,45");
        LottoGame lottoGame = new LottoGame(5000, slipLottos);
        assertEquals( 5,lottoGame.getLottos().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 유효하지않은_보너스볼을넣는다() {
        List<String> slipLottos = new ArrayList<>();
        slipLottos.add("1,2,3,4,5,6");
        LottoGame lottoGame = new LottoGame(1000, slipLottos);
        lottoGame.startLottoGame(winningLotto, new LottoNo(1));
    }

    @Test
    public void 이등만_당첨된경우() {
        List<String> slipLottos = new ArrayList<>();
        slipLottos.add("1,2,3,4,5,9");
        LottoGame lottoGame = new LottoGame(1000, slipLottos);
        LottoGameResultDTO lottoGameResultDTO = lottoGame.startLottoGame(winningLotto, new LottoNo(9));

        assertEquals(new Integer(1), lottoGameResultDTO.getRankCount().get(Rank.SECOND));
    }

    @Test
    public void 이등과_오등이_당첨된경우() {
        List<String> slipLottos = new ArrayList<>();
        slipLottos.add("1,2,3,4,5,9");
        slipLottos.add("1,2,3,43,44,45");
        LottoGame lottoGame = new LottoGame(2000, slipLottos);
        LottoGameResultDTO lottoGameResultDTO = lottoGame.startLottoGame(winningLotto, new LottoNo(9));

        assertEquals(new Integer(1), lottoGameResultDTO.getRankCount().get(Rank.FIFTH));
        assertEquals(new Integer(1), lottoGameResultDTO.getRankCount().get(Rank.SECOND));
    }


}