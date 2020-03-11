package controller;

import model.*;
import util.StringSpliter;
import view.InputView;
import view.ResultView;

public class Main {
    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();
        int slipCount = InputView.inputSlipCount();

        LottoGame lottoGame = new LottoGame(inputMoney, InputView.inputSlipNumbers(slipCount));
        ResultView.printLottos(inputMoney, slipCount, lottoGame.getLottos());
        WinningLotto winningLotto = new WinningLotto(StringSpliter.makeLottoNo(InputView.inputLastJackpot()));
        ResultView.printStatistics(lottoGame.startLottoGame(winningLotto, new LottoNo(InputView.inputBonusBall())));
    }
}
