package model;

import dto.LottoDTO;
import dto.LottoGameResultDTO;
import util.Rank;
import util.StringSpliter;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;
    private int InputMoney;
    public static final int LOTTO_PRICE = 1000;

    public LottoGame(int inputMoney, List<String> sliplottos) {
        this.InputMoney = inputMoney;
        checkMoney(inputMoney, sliplottos);
        lottos = new ArrayList<>();
        this.lottos = makeSlipLottos(sliplottos);
        this.lottos = makeQuickPickLottos((inputMoney - LOTTO_PRICE * sliplottos.size()) / LOTTO_PRICE);
    }

    private void checkMoney(int inputMoney, List<String> sliplottos) {
        if (0 > inputMoney - (sliplottos.size() * LOTTO_PRICE) || inputMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("돈이부족합니다");
        }
    }

    private List<Lotto> makeSlipLottos(List<String> sliplottos) {
        for (int i = 0; i < sliplottos.size(); i++) {
            Lotto lotto = new Lotto(StringSpliter.makeLottoNo(sliplottos.get(i)));
            lottos.add(lotto);
        }
        return lottos;
    }

    private List<Lotto> makeQuickPickLottos(int quickPickCount) {
        for (int i = 0; i < quickPickCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<LottoDTO> getLottos() {
        List<LottoDTO> lottosDTO = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottosDTO.add(lotto.returnLottoDTO());
        }
        return lottosDTO;
    }

    public LottoGameResultDTO startLottoGame(WinningLotto winningLotto, LottoNo bonusBall) {
        validateBounusBall(winningLotto, bonusBall);
        LottoGameResult lottoGameResult = new LottoGameResult(InputMoney);
        for (Lotto lotto : lottos) {
            int sameNumberCount = winningLotto.getSameNumberCount(lotto);
            lottoGameResult.addRankCount(Rank.valueOf(sameNumberCount, lotto.hasNumber(bonusBall)));
        }
        return lottoGameResult.returnResultDTO();
    }

    private void validateBounusBall(WinningLotto winningLotto, LottoNo bonusBall) {
        if (winningLotto.hasNumber(bonusBall)) {
            throw new IllegalArgumentException("보너스볼은 당첨로또에 없는 번호여야 합니다");
        }
    }
}
