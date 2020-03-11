package model;

import dto.LottoGameResultDTO;
import util.Rank;

import java.util.HashMap;
import java.util.Map;



public class LottoGameResult {
    private Map<Rank, Integer> rankCount = new HashMap<>();
    private int winMoney = 0;
    private int inputMoney;

    public LottoGameResult(int inputMoney){
        this.inputMoney = inputMoney;
        rankCount.put(Rank.FIRST, 0);
        rankCount.put(Rank.SECOND, 0);
        rankCount.put(Rank.THIRD, 0);
        rankCount.put(Rank.FOURTH, 0);
        rankCount.put(Rank.FIFTH, 0);
        rankCount.put(Rank.MISS, 0);
    }

    public Map<Rank, Integer> addRankCount(Rank resultRank) {
        int count = rankCount.get(resultRank);
        count++;
        rankCount.put(resultRank, count);
        addWinMoney(resultRank);
        return rankCount;
    }

    private double addWinMoney(Rank resultRank) {
        winMoney += resultRank.getWinningMoney();
        return winMoney;
    }

    public LottoGameResultDTO returnResultDTO() {
        LottoGameResultDTO lottoGameResultDTO = new LottoGameResultDTO(rankCount,(double)winMoney/inputMoney*100);
        return lottoGameResultDTO;
    }
}
