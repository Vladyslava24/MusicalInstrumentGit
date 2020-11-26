package enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResonatorsLengthTest {
    private ResonatorsLength length;

    @Test
    public void whenIsShortResonatorsThenReturnTrue() {
        length = ResonatorsLength.SHORT;
        assertTrue(length.isShortResonators());
    }

    @Test
    public void whenIsShortResonatorsNotShortThenReturnFalse() {
        length = ResonatorsLength.LONG;
        assertFalse(length.isShortResonators());
    }

    @Test
    public void whenIsMediumResonatorsThenReturnTrue() {
        length = ResonatorsLength.MEDIUM;
        assertTrue(length.isMediumResonators());
    }

    @Test
    public void whenIsMediumResonatorsNotMediumThenReturnFalse() {
        length = ResonatorsLength.SHORT;
        assertFalse(length.isMediumResonators());
    }

    @Test
    public void whenIsLongResonatorsThenReturnTrue() {
        length = ResonatorsLength.LONG;
        assertTrue(length.isLongResonators());
    }

    @Test
    public void whenIsLongResonatorsNotLongThenReturnFalse() {
        length = ResonatorsLength.MEDIUM;
        assertFalse(length.isLongResonators());
    }
}