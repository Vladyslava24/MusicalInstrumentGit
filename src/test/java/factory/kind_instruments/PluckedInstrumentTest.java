package factory.kind_instruments;

import enums.Material;
import enums.Resonators;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PluckedInstrumentTest {

    @Test
    public void whenInitInstrumentThenGetSizeOfList() {
        PluckedInstrument pluckedInstrument = new PluckedInstrument();
        List<PluckedInstrument> pluckedInstrumentList  = new ArrayList<>();
        assertThat(pluckedInstrumentList.size(), is(0));
        pluckedInstrumentList = pluckedInstrument.initInstrument();
        assertThat(pluckedInstrumentList.size(), is(3));
    }
}