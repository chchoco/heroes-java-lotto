package model;

public class LottoNo implements Comparable<LottoNo> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private int no;

    public int getNo() {
        return no;
    }

    public LottoNo(int no) {
        if (no < MIN_LOTTO_NUMBER || no > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("1~45까지의 숫자만 가능합니다.");
        }
        this.no = no;
    }

    public String toString() {
        return Integer.toString(no);
    }

    @Override
    public int compareTo(LottoNo lottoNo) {
        return Integer.compare(no, lottoNo.getNo());
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        LottoNo other = (LottoNo) obj;
        if (no == other.no) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + no;
        return result;
    }
}
