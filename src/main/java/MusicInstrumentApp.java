import factory.StringedInstrumentFactory;

public class MusicInstrumentApp {
    public static void main(String[] args) {
        //factory.StringedInstrumentFactory stringedFactory = (factory.StringedInstrumentFactory) getFactoryByKindInstrument(GeneralKind.STRINGLED);
        try {
            StringedInstrumentFactory stringedInstrumentFactory = new StringedInstrumentFactory();
            stringedInstrumentFactory.makeBowedInstruments();
            stringedInstrumentFactory.objectComprasion(stringedInstrumentFactory.getFactoryBowedList());
            StringedInstrumentFactory.Statistics statistics = stringedInstrumentFactory.new Statistics();
            System.out.println("Make statistics of produced instruments");
            System.out.println();
            statistics.makeStatistics();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
