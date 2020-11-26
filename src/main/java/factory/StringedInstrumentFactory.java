package factory;

import exception.NotFoundInstrumentException;
import factory.kind_instruments.BowedInstrument;

import java.text.DecimalFormat;
import java.util.*;

public class StringedInstrumentFactory {
    private List<BowedInstrument> factoryBowedList;

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

    public class Statistics{
        private int generalAmount;
        private int amountBowed;

        public void makeStatistics(){
            try {
                generalAmount = calculateInstrumentAmount();
                amountBowed = calculateBowedAmount();
                System.out.println("Amount of stringed instruments: " + generalAmount);
                System.out.println("Amount of bowed instruments: " + amountBowed);
                DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
                String bowed = decimalFormat.format(calculateBowedPercentage());
                System.out.println("Percentage of bowed instruments: "+ bowed +"%");
                countBowedDuplicates(factoryBowedList);
                System.out.println("----------");
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

        public double calculateBowedPercentage(){
            double bowedPercentage = (double) amountBowed/ (double) generalAmount * 100;
            return bowedPercentage;
        }

        public int calculateBowedAmount(){
            return factoryBowedList.size();
        }

        public int calculateInstrumentAmount() throws NotFoundInstrumentException {
            int generalSize = getFactoryBowedList().size();
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

    public void setFactoryBowedList(List<BowedInstrument> factoryBowedList) {
        this.factoryBowedList = factoryBowedList;
    }
}
