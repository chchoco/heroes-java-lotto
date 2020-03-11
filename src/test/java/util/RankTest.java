package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {

    @Test
    public void 등수안에없는경우() {
        assertEquals(Rank.MISS, Rank.valueOf(0, false));
        assertEquals(Rank.MISS, Rank.valueOf(1, false));
        assertEquals(Rank.MISS, Rank.valueOf(2, false));
    }

    @Test
    public void 일등일경우() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
    }

    @Test
    public void 이등일경우() {
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
    }

    @Test
    public void 삼등일경우() {
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
    }

    @Test
    public void 사등일경우() {
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
    }

    @Test
    public void 오등일경우() {
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
    }
}