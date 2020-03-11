package dto;

import util.Rank;

import java.util.Map;

public class LottoGameResultDTO {
    private Map<Rank, Integer> rankCount;
    private double rateOfReturn;


    public LottoGameResultDTO(Map<Rank, Integer> rankCount, double rateOfReturn) {
        this.rankCount = rankCount;
        this. rateOfReturn =  rateOfReturn;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }
}
