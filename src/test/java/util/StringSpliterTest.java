package util;

import model.LottoNo;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StringSpliterTest {
    @Test
    public void 숫자를입력받아_LottoNo리스트로만든다() {
        List<LottoNo> numbers;
        numbers = StringSpliter.makeLottoNo("1,2,3,4,5,6");
        List<LottoNo> testNumbers = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4),
                new LottoNo(5), new LottoNo(6));
        assertEquals(6, numbers.size());
        assertEquals(numbers, testNumbers);
    }
}