package model;

import dto.LottoDTO;
import util.RandomLottoNoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private List<LottoNo> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = RandomLottoNoGenerator.makeQuickPick();
    }

    public Lotto(List<LottoNo> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }


    private void validateSize(List<LottoNo> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또번호는 6개만 가능합니다");
        }
    }

    private void validateDuplicate(List<LottoNo> lottoNumbers) {
        List<Integer> subDuplicate = new ArrayList<>();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            subDuplicate = addNonDuplicateNumber(lottoNumbers, subDuplicate, i);
        }
        if (subDuplicate.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또번호는 중복될수 없습니다.");
        }
    }

    private List addNonDuplicateNumber(List<LottoNo> lottoNumbers, List<Integer> subDuplicate, int i) {
        if (!subDuplicate.contains(lottoNumbers.get(i).getNo())) {
            subDuplicate.add(lottoNumbers.get(i).getNo());
        }
        return subDuplicate;
    }

    public boolean hasNumber(LottoNo no) {
        if (lottoNumbers.contains(no)) {
            return true;
        }
        return false;
    }

    public LottoDTO returnLottoDTO() {
        Lotto lotto = new Lotto(lottoNumbers);
        LottoDTO lottoDTO = new LottoDTO(lotto);
        return lottoDTO;
    }

    public String toString() {
        return "" + lottoNumbers;
    }


    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        Lotto lotto = (Lotto) obj;
        if (lottoNumbers.equals(lotto.lottoNumbers)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lottoNumbers == null) ? 0 : lottoNumbers.hashCode());
        return result;
    }
}
