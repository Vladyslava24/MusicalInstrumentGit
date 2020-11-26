package factory.kind_instruments;

import enums.Material;
import enums.Resonators;
import factory.MusicalInstrument;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class BowedInstrument extends MusicalInstrument implements Stringed {
    private static final String CHARACTER = "\n";
    private Resonators resonators;
    private String playingWay;
    private String additionalSubject;

    public BowedInstrument(){

    }

    public BowedInstrument(String name, String soundSource, boolean resonatorPresence, Material instrumentMaterial, Resonators resonators, String playingWay, String additionalSubject) {
        super(name, soundSource, resonatorPresence, instrumentMaterial);
        this.resonators = resonators;
        this.playingWay = playingWay;
        this.additionalSubject = additionalSubject;
    }

    //TODO make list of constants
    @Override
    public List<BowedInstrument> initInstrument() {
        List<BowedInstrument> bowedList = new ArrayList<>();
                bowedList.add(new BowedInstrument("Violin", "string", true, Material.FIR,
                        Resonators.STRINGED_MEDIUM, "bow", "bow"));
                bowedList.add(new BowedInstrument("Cello", "string", true, Material.CEDAR,
                        Resonators.STRINGED_MEDIUM, "bow","bow"));
                bowedList.add(new BowedInstrument("Double bass", "string", true, Material.CEDAR,
                        Resonators.STRINGED_LONG, "bow","bow"));
        return bowedList;
    }

    @Override
    public void generateSound() {
        ListIterator<BowedInstrument> listIterator = initInstrument().listIterator();
        while (listIterator.hasNext()){
            BowedInstrument nextInstrument = listIterator.next();
            if(nextInstrument.getResonators().getResonatorsLength().isShortResonators()){
                System.out.println(nextInstrument.name+" plays high sound");
            } else  if(nextInstrument.getResonators().getResonatorsLength().isMediumResonators()){
                System.out.println(nextInstrument.name+" plays middle sound");
            } else  if(nextInstrument.getResonators().getResonatorsLength().isLongResonators()){
                System.out.println(nextInstrument.name+" plays low sound");
            }
        }
    }

    public static String stringRepresentation(BowedInstrument bowedInstrument){
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append("Instrument name: ")
                 .append(bowedInstrument.name)
                 .append(CHARACTER)
                 .append("Sound source: ")
                 .append(bowedInstrument.soundSource)
                 .append(CHARACTER)
                 .append("Resonator presence: ")
                 .append(bowedInstrument.resonatorPresence)
                 .append(CHARACTER)
                 .append("Instrument material: ")
                 .append(bowedInstrument.instrumentMaterial.name().toLowerCase())
                 .append(Material.valueOf(bowedInstrument.instrumentMaterial.name()))
                 .append("\n")
                 .append("Resonators: ")
                 .append(bowedInstrument.getResonators().name().toLowerCase())
                 .append(", resonators amount: ")
                 .append(Resonators.valueOf(bowedInstrument.getResonators().name()).getResonatorsAmount().getResonatorAmount())
                 .append(", resonators length: ")
                 .append(Resonators.valueOf(bowedInstrument.getResonators().name()).getResonatorsLength().getLength())
                 .append("\n")
                 .append("Playing way: ")
                 .append(bowedInstrument.getPlayingWay())
                 .append("\n")
                 .append("Additional subject: ")
                 .append(bowedInstrument.getAdditionalSubject());
         return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        BowedInstrument instrument = (BowedInstrument) obj;
        return  Objects.equals(name, instrument.name) &&
                Objects.equals(soundSource, instrument.soundSource) &&
                Objects.equals(instrumentMaterial, instrument.instrumentMaterial) &&
                Objects.equals(resonators, instrument.resonators) &&
                Objects.equals(playingWay, instrument.playingWay) &&
                Objects.equals(additionalSubject, instrument.additionalSubject);
    }

    public Resonators getResonators() {
        return resonators;
    }

    public void setResonators(Resonators resonators) {
        this.resonators = resonators;
    }

    public String getPlayingWay() {
        return playingWay;
    }

    public void setPlayingWay(String playingWay) {
        this.playingWay = playingWay;
    }

    public String getAdditionalSubject() {
        return additionalSubject;
    }

    public void setAdditionalSubject(String additionalSubject) {
        this.additionalSubject = additionalSubject;
    }

    @Override
    public String toString() {
        return "factory.kind_instruments.BowedInstrument{" +
                "resonators=" + resonators +
                ", playingWay='" + playingWay + '\'' +
                ", additionalSubject='" + additionalSubject + '\'' +
                '}';
    }
}
