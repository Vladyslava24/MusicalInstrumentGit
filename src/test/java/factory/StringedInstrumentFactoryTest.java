package factory;

import enums.Material;
import enums.Resonators;
import exception.NotFoundInstrumentException;
import factory.kind_instruments.BowedInstrument;
import factory.kind_instruments.PluckedInstrument;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StringedInstrumentFactoryTest {
    private StringedInstrumentFactory instrumentFactory = new StringedInstrumentFactory();
    private List<BowedInstrument> bowedInstrumentList = new ArrayList<>();
    private List <PluckedInstrument> pluckedInstrumentList= new ArrayList<>();

    @Before
    public void setUp() {
        bowedInstrumentList.add(new BowedInstrument("Violin", "string", true, Material.FIR,
                Resonators.STRINGED_MEDIUM, "bow", "bow"));
        bowedInstrumentList.add(new BowedInstrument("Cello", "string", true, Material.CEDAR,
                Resonators.STRINGED_MEDIUM, "bow","bow"));
        bowedInstrumentList.add(new BowedInstrument("Double bass", "string", true, Material.CEDAR,
                Resonators.STRINGED_LONG, "bow","bow"));
        instrumentFactory.setFactoryBowedList(bowedInstrumentList);
        pluckedInstrumentList.add(new PluckedInstrument("Guitar", "string", true, Material.SPRICE,
                Resonators.STRINGED_MEDIUM, "fingers"));
        pluckedInstrumentList.add(new PluckedInstrument("Cello", "string", true, Material.FIR,
                Resonators.STRINGED_MEDIUM, "fingers"));
        pluckedInstrumentList.add(new PluckedInstrument("Uculele", "string", true, Material.CEDAR,
                Resonators.STRINGED_SMALL, "fingers"));
        instrumentFactory.setFactoryPluckedList(pluckedInstrumentList);
    }


    @Test
    public void whenGenerateRandomNumberInGivenRangeThenReturnTrue() {
        int number = instrumentFactory.generateRandomNumber(0, 10);
        assertTrue(number>=0 && number<=10);
        assertFalse(number<0 || number>10);
    }

    @Test
    public void whenCalculateBowedAmountThenReturnSize(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(3, statistics.calculateBowedAmount());
    }

    @Test
    public void whenCalculatePluckedAmountThenReturnSize(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(3, statistics.calculatePluckedAmount());
    }

    @Test
    public void whenCalculateInstrumentAmountThenReturnSize(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(6, statistics.calculateInstrumentAmount());
    }

    @Test(expected = NotFoundInstrumentException.class)
    public void whenCalculateInstrumentAmountWithZeroValueThenThrowNotFoundInstrumentException(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        List<BowedInstrument> bowedList = new ArrayList<>();
        List<PluckedInstrument> pluckedList = new ArrayList<>();
        instrumentFactory.setFactoryBowedList(bowedList);
        instrumentFactory.setFactoryPluckedList(pluckedList);
        statistics.calculateInstrumentAmount();
    }

    @Test
    public void whenDefineAmountShortStringsThenReturnAmount(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(1, statistics.defineAmountShortStrings());
    }

    @Test
    public void whenDefineAmountMediumStringsThenReturnAmount(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(4, statistics.defineAmountMediumStrings());
    }

    @Test
    public void  whenDefineAmountLongStringsThenReturnAmount(){
        StringedInstrumentFactory.Statistics statistics = instrumentFactory.new Statistics();
        assertEquals(1, statistics.defineAmountLongStrings());
    }
}