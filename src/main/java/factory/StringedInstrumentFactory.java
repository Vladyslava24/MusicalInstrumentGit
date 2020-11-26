package factory;

import exception.NotFoundInstrumentException;
import factory.kind_instruments.BowedInstrument;
import factory.kind_instruments.PluckedInstrument;

import java.text.DecimalFormat;
import java.util.*;

public class StringedInstrumentFactory {
    private List<BowedInstrument> factoryBowedList;
    private List<PluckedInstrument> factoryPluckedList;

    public StringedInstrumentFactory() {
    }

    public int generateRandomNumber(int min, int max) {
        int number = (int) (min + Math.random() * (max - min + 1));
        return number;
    }

    public void makeBowedInstruments() throws NotFoundInstrumentException {
        BowedInstrument bowedInstrument = new BowedInstrument();
        List<BowedInstrument> bowedInstrumentList = bowedInstrument.initInstrument();
        if(bowedInstrumentList == null || bowedInstrumentList.size()==0) {
            throw new NotFoundInstrumentException("List of bowed instruments is not found");
        }
        factoryBowedList = new ArrayList<>();
        int collectionSize = 0;
        while(collectionSize < bowedInstrumentList.size()) {
            BowedInstrument instrument = bowedInstrumentList.get(collectionSize);
            int randomAmount = generateRandomNumber(5, 11);
            System.out.println("Random number: " + randomAmount);
            int counter = 0;
            while (counter < randomAmount) {
                factoryBowedList.add(instrument);
                counter++;
            }
            collectionSize++;
        }
        collectionBowedIterate(factoryBowedList);
    }

    public void makePluckedInstruments() throws NotFoundInstrumentException{
        PluckedInstrument pluckedInstrument = new PluckedInstrument();
        try {
            List<PluckedInstrument> pluckedInstrumentList = pluckedInstrument.initInstrument();
            if (pluckedInstrumentList == null || pluckedInstrumentList.size()==0) {
                throw new NotFoundInstrumentException("List of plucked instruments is not found");
            }
            factoryPluckedList = new ArrayList<>();
            int collectionSize = 0;
            while(collectionSize < pluckedInstrumentList.size()) {
                PluckedInstrument instrument = pluckedInstrumentList.get(collectionSize);
                int randomAmount = generateRandomNumber(5, 11);
                System.out.println("Random number: " + randomAmount);
                int counter = 0;
                while (counter < randomAmount) {
                    factoryPluckedList.add(instrument);
                    counter++;
                }
                collectionSize++;
            }
        } catch (NotFoundInstrumentException e){
            e.getMessage();
        }
        collectionPluckedIterate(factoryPluckedList);
    }

    public void collectionBowedIterate(List<BowedInstrument> factoryList){
        ListIterator<BowedInstrument> listIterator = factoryList.listIterator();
        int count = 1;
        while (listIterator.hasNext()){
            BowedInstrument nextInstrument = listIterator.next();
            System.out.println("Instrument #"+ count+ "\n"+ BowedInstrument.stringRepresentation(nextInstrument)+"\n\n");
            count++;
        }
        System.out.println(factoryList.size());
    }

    public void collectionPluckedIterate(List<PluckedInstrument> factoryList){
        ListIterator<PluckedInstrument> listIterator = factoryList.listIterator();
        int count = 1;
        while (listIterator.hasNext()){
            PluckedInstrument nextInstrument = listIterator.next();
            System.out.println("Instrument #"+ count+ "\n"+ PluckedInstrument.stringRepresentation(nextInstrument)+"\n\n");
            count++;
        }
        System.out.println(factoryList.size());
    }


    public class Statistics{
        private int generalAmount;
        private int amountBowed;
        private int amountPlucked;

        public void makeStatistics(){
            try {
                generalAmount = calculateInstrumentAmount();
                amountBowed = calculateBowedAmount();
                amountPlucked = calculatePluckedAmount();
                System.out.println("Amount of stringed instruments: " + generalAmount);
                System.out.println("Amount of bowed instruments: " + amountBowed);
                System.out.println("Amount of plucked instruments: " + amountPlucked);
                DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
                String bowed = decimalFormat.format(calculateBowedPercentage());
                String plucked = decimalFormat.format(calculatePluckedPercentage());
                System.out.println("Percentage of bowed instruments: "+ bowed +"%");
                System.out.println("Percentage of plucked instruments: "+plucked + "%");
                countBowedDuplicates(factoryBowedList);
                System.out.println("----------");
                countPluckedDuplicates(factoryPluckedList);
                System.out.println("Amount of instruments with short strings: "+ defineAmountShortStrings());
                System.out.println("Amount of instruments with medium strings: "+ defineAmountMediumStrings());
                System.out.println("Amount of instruments with long strings: "+ defineAmountLongStrings());
            } catch (NotFoundInstrumentException e){
                e.printStackTrace();
            }
        }

        public void countBowedDuplicates(List<BowedInstrument> list){
            Set<BowedInstrument> set = new HashSet<>(list);
            String str = "";
            for (BowedInstrument instrument : set) {
                str += instrument.name + ": " + Collections.frequency(list, instrument) + '#';
            }
            for (String subString : str.split("#")) {
                System.out.println(subString);
            }
        }

        public void countPluckedDuplicates(List<PluckedInstrument> list){
            Set<PluckedInstrument> set = new HashSet<>(list);
            String str = "";
            for (PluckedInstrument instrument : set) {
                str += instrument.name + ":" + Collections.frequency(list, instrument) + '#';
            }
            for (String subString : str.split("#")) {
                System.out.println(subString);
            }
        }

        public double calculateBowedPercentage(){
            double bowedPercentage = (double) amountBowed/ (double) generalAmount * 100;
            return bowedPercentage;
        }

        public double calculatePluckedPercentage(){
            double pluckedPercentage = (double) amountPlucked/ (double) generalAmount * 100;
            return pluckedPercentage;
        }

        public long defineAmountShortStrings(){
            long bowedShort = factoryBowedList.stream().filter((p)->p.getResonators().getResonatorsLength()
                    .isShortResonators()).count();
            long pluckedShort = factoryPluckedList.stream().filter((p)->p.getResonators().getResonatorsLength()
                    .isShortResonators()).count();
            return bowedShort + pluckedShort;
        }

        public long defineAmountMediumStrings(){
            long bowedMedium = factoryBowedList.stream().filter((p)->p.getResonators().getResonatorsLength()
                    .isMediumResonators()).count();
            long pluckedMedium = factoryPluckedList.stream().filter((p)->p.getResonators().getResonatorsLength()
                    .isMediumResonators()).count();
            return bowedMedium + pluckedMedium;
        }

        public long defineAmountLongStrings(){
            long bowedLong = factoryBowedList.stream().filter((p)->p.getResonators().getResonatorsLength()
                    .isLongResonators()).count();
            long pluckedLong = factoryPluckedList.stream().filter((p)->p.getResonators().getResonatorsLength()
                    .isLongResonators()).count();
            return bowedLong+ pluckedLong;
        }

        public int calculateBowedAmount(){
            return factoryBowedList.size();
        }

        public int calculatePluckedAmount(){
            return factoryPluckedList.size();
        }

        public int calculateInstrumentAmount() throws NotFoundInstrumentException {
            int generalSize = getFactoryBowedList().size()+ getFactoryPluckedList().size();
            if(generalSize == 0)
                throw new NotFoundInstrumentException("Cannot make statistics, there aren't instruments in factory");
            return generalSize;
        }
    }

    public void objectComprasion(List<BowedInstrument> factoryList) throws IndexOutOfBoundsException{
        int indexObj1 = generateRandomNumber(0, factoryList.size() - 1);
        int indexObj2 = generateRandomNumber(0, factoryList.size() - 1);
        //int indexObj2 = generateRandomNumber(-10, -3);
        if(indexObj1<0 || indexObj2<0 || indexObj1>factoryList.size()-1 || indexObj2>factoryList.size()-1)
            throw new IndexOutOfBoundsException("Index of list is out of range");
        BowedInstrument obj1 = factoryList.get(indexObj1);
        BowedInstrument obj2 = factoryList.get(indexObj2);
        System.out.println(BowedInstrument.stringRepresentation(obj1));
        System.out.println(BowedInstrument.stringRepresentation(obj2));
        if (obj1.equals(obj1)) {
            System.out.println("Same objects");
        } else {
            System.out.println("Different objects");
        }
        if (obj1.equals(obj2)) {
            System.out.println("Same objects");
        } else {
            System.out.println("Different objects");
        }
        if (obj1.hashCode() == obj1.hashCode()) {
            System.out.println("Maybe, same objects");
        } else {
            System.out.println("Different objects exactly");
        }
        if (obj1.hashCode() == obj2.hashCode()) {
            System.out.println("Maybe, same objects");
        } else {
            System.out.println("Different objects exactly");
        }
    }

    public List<BowedInstrument> getFactoryBowedList() {
        return factoryBowedList;
    }

    public List<PluckedInstrument> getFactoryPluckedList() {
        return factoryPluckedList;
    }

    public void setFactoryBowedList(List<BowedInstrument> factoryBowedList) {
        this.factoryBowedList = factoryBowedList;
    }

    public void setFactoryPluckedList(List<PluckedInstrument> factoryPluckedList) {
        this.factoryPluckedList = factoryPluckedList;
    }
}
