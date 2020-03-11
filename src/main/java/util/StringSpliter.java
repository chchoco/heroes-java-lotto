package util;

import model.LottoNo;

import java.util.ArrayList;
import java.util.List;

public class StringSpliter {

    public static List<LottoNo> makeLottoNo(String inputNumbers) {
        List<LottoNo> numbers = new ArrayList<>();
        inputNumbers = inputNumbers.replaceAll(" ", "");
        String[] splitNumbers = inputNumbers.split(",");
        for (int i = 0; i < splitNumbers.length; i++) {
            numbers.add(new LottoNo(Integer.parseInt(splitNumbers[i])));
        }
        return numbers;
    }
}
