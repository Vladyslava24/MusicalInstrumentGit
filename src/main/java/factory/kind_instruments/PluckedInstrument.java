package factory.kind_instruments;

import enums.Material;
import enums.Resonators;
import factory.MusicalInstrument;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PluckedInstrument extends MusicalInstrument implements Stringed {
    private Resonators resonators;
    private String playingWay;

    public PluckedInstrument() {
    }

    public PluckedInstrument(String name, String soundSource, boolean resonatorPresence, Material instrumentMaterial, Resonators resonators, String playingWay) {
        super(name, soundSource, resonatorPresence, instrumentMaterial);
        this.resonators = resonators;
        this.playingWay = playingWay;
    }

    @Override
    public void generateSound() {
        ListIterator<PluckedInstrument> listIterator = initInstrument().listIterator();
        while (listIterator.hasNext()){
            PluckedInstrument nextInstrument = listIterator.next();
            if(nextInstrument.getResonators().getResonatorsLength().isShortResonators()){
                System.out.println(nextInstrument.name+" plays high sound");
            } else  if(nextInstrument.getResonators().getResonatorsLength().isMediumResonators()){
                System.out.println(nextInstrument.name+" plays middle sound");
            } else  if(nextInstrument.getResonators().getResonatorsLength().isLongResonators()){
                System.out.println(nextInstrument.name+" plays low sound");
            }
        }
    }

    //TODO make list of constants
    @Override
    public List initInstrument() {
        List<PluckedInstrument> pluckedList = new ArrayList<>();
        pluckedList.add(new PluckedInstrument("Guitar", "string", true, Material.SPRICE,
                Resonators.STRINGED_MEDIUM, "fingers"));
        pluckedList.add(new PluckedInstrument("Cello", "string", true, Material.FIR,
                Resonators.STRINGED_MEDIUM, "fingers"));
        pluckedList.add(new PluckedInstrument("Uculele", "string", true, Material.CEDAR,
                Resonators.STRINGED_SMALL, "fingers"));
        return pluckedList;
    }

    public static String stringRepresentation(PluckedInstrument pluckedInstrument){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Instrument name: ")
                .append(pluckedInstrument.name)
                .append("\n")
                .append("Sound source: ")
                .append(pluckedInstrument.soundSource)
                .append("\n")
                .append("Resonator presence: ")
                .append(pluckedInstrument.resonatorPresence)
                .append("\n")
                .append("Instrument material: ")
                .append(pluckedInstrument.instrumentMaterial.name().toLowerCase())
                .append(Material.valueOf(pluckedInstrument.instrumentMaterial.name()))
                .append("\n")
                .append("Resonators: ")
                .append(pluckedInstrument.getResonators().name().toLowerCase())
                .append(", resonators amount: ")
                .append(Resonators.valueOf(pluckedInstrument.getResonators().name()).getResonatorsAmount().getResonatorAmount())
                .append(", resonators length: ")
                .append(Resonators.valueOf(pluckedInstrument.getResonators().name()).getResonatorsLength().getLength())
                .append("\n")
                .append("Playing way: ")
                .append(pluckedInstrument.getPlayingWay());
        return stringBuilder.toString();
    }

    public Resonators getResonators() {
        return resonators;
    }

    public String getPlayingWay() {
        return playingWay;
    }
}