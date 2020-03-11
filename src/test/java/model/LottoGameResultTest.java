package model;

import util.Rank;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Map;

public class LottoGameResultTest {

    @Test
    public void Rank의개수를출력한다() {
        Map<Rank, Integer> rankCount;
        LottoGameResult lottoGameResult = new LottoGameResult(2000);
        rankCount = lottoGameResult.addRankCount(Rank.FIRST);
        assertEquals(new Integer(1), rankCount.get(Rank.FIRST));

        rankCount = lottoGameResult.addRankCount(Rank.FIRST);
        assertEquals(new Integer(2), rankCount.get(Rank.FIRST));
    }

    @Test
    public void 수익률을확인한다() {
        LottoGameResult lottoGameResult = new LottoGameResult(14000);
        lottoGameResult.addRankCount(Rank.FIFTH);
        double money = ((double) Rank.FIFTH.getWinningMoney() / 14000) * 100;
        assertEquals(money, lottoGameResult.returnResultDTO().getRateOfReturn(), 0.05);
    }
}