package util;

public enum Rank {//일치하는수를 로또 등수로 변환한다.
    //public satic final Rank FIRST = new FIRST(6,20000000);
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == 5 && !matchBonus) {
            return Rank.THIRD;
        }

        Rank resultRank = MISS;
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (rank.getCountOfMatch() == countOfMatch) {
                resultRank = rank;
                return resultRank;
            }
        }
        return resultRank;
    }
}