package dto;

import model.Lotto;

public class LottoDTO {
    private Lotto lotto;

    public LottoDTO(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getLotto() {
        return lotto;
    }
}
