package factory;

import enums.Material;

public abstract class MusicalInstrument {
    protected String name;
    protected String soundSource;
    protected boolean resonatorPresence;
    protected Material instrumentMaterial;

    public MusicalInstrument() {
    }

    public MusicalInstrument(String name, String soundSource, boolean resonatorPresence, Material instrumentMaterial) {
        this.name = name;
        this.soundSource = soundSource;
        this.resonatorPresence = resonatorPresence;
        this.instrumentMaterial = instrumentMaterial;
    }

    public abstract void generateSound();

}
