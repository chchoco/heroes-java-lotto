package view;


import dto.LottoDTO;
import dto.LottoGameResultDTO;
import model.Lotto;
import util.Rank;

import java.util.List;
import java.util.Map;


public class ResultView {
    public static final int LOTTO_PRICE = 1000;

    public static void prinAlltLottos(int slipCount, int qucipickCount, List<Lotto> lottos) {
        System.out.println("수동으로" + slipCount + "개, 자동으로" + qucipickCount + "개 구매했습니다");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printLottos(int inputMoney, int slipCount, List<LottoDTO> lottos) {
        int quickPickCount = (inputMoney - LOTTO_PRICE * slipCount) / LOTTO_PRICE;
        System.out.println("수동으로" + slipCount + "개, 자동으로" + quickPickCount + "개 구매했습니다");
        for (LottoDTO lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public static void printStatistics(LottoGameResultDTO result) {
        Map<Rank, Integer> rankingResult = result.getRankCount();
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("--------");
        System.out.println(Rank.FIFTH.getCountOfMatch() + "개 일치 (" + Rank.FIFTH.getWinningMoney() + "원)- " + rankingResult.get(Rank.FIFTH) + "개");
        System.out.println(Rank.FOURTH.getCountOfMatch() + "개 일치 (" + Rank.FOURTH.getWinningMoney() + "원)- " + rankingResult.get(Rank.FOURTH) + "개");
        System.out.println(Rank.THIRD.getCountOfMatch() + "개 일치 (" + Rank.THIRD.getWinningMoney() + "원)- " + rankingResult.get(Rank.THIRD) + "개");
        System.out.println(Rank.SECOND.getCountOfMatch() + "개 일치 (" + Rank.SECOND.getWinningMoney() + "원)- " + rankingResult.get(Rank.SECOND) + "개");
        System.out.println(Rank.FIRST.getCountOfMatch() + "개 일치 (" + Rank.FIRST.getWinningMoney() + "원)- " + rankingResult.get(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + String.format("%.1f",result.getRateOfReturn()) + "% 입니다");
    }
}
