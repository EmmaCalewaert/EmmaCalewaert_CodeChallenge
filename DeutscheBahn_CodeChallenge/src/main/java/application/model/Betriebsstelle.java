package application.model;

import java.util.zip.DataFormatException;


public final class Betriebsstelle {
    private String PLC;
    private String RL100Code;
    private String RL100Langname;
    private String RL100Kurzname;
    private String TypKurz;
    private String TypLang;
    private String Betriebszustand;
    private String DatumAb;
    private String DatumBis;
    private String Niederlassung;
    private String Regionalbereich;
    private String LetzteAenderung;

    public Betriebsstelle(String PLC, String RL100Code, String RL100Langname, String RL100Kurzname, String typKurz, String typLang,
                          String betriebszustand, String datumAb, String datumBis, String niederlassung, String regionalbereich, String letzteAenderung) {
        this.PLC = PLC;
        this.RL100Code = RL100Code;
        this.RL100Langname = RL100Langname;
        this.RL100Kurzname = RL100Kurzname;
        TypKurz = typKurz;
        TypLang = typLang;
        Betriebszustand = betriebszustand;
        DatumAb = datumAb;
        DatumBis = datumBis;
        Niederlassung = niederlassung;
        Regionalbereich = regionalbereich;
        LetzteAenderung = letzteAenderung;
    }

    private final static int NUM_TO_PARSE = 12;
    public Betriebsstelle(String[] line) throws DataFormatException {
        if(line.length != NUM_TO_PARSE) throw new DataFormatException(String.format("Data length incorrect! Should have %i strings to parse.", NUM_TO_PARSE));
        this.PLC = line[0];
        this.RL100Code = line[1];
        this.RL100Langname = line[2];
        this.RL100Kurzname = line[3];
        TypKurz = line[4];
        TypLang = line[5];
        Betriebszustand = line[6];
        DatumAb = line[7];
        DatumBis = line[8];
        Niederlassung = line[9];
        Regionalbereich = line[10];
        LetzteAenderung = line[11];
    }

    public String getPLC() {
        return PLC;
    }

    public String getRL100Code() {
        return RL100Code;
    }

    public String getRL100Langname() {
        return RL100Langname;
    }

    public String getRL100Kurzname() {
        return RL100Kurzname;
    }

    public String getTypKurz() {
        return TypKurz;
    }

    public String getTypLang() {
        return TypLang;
    }

    public String getBetriebszustand() {
        return Betriebszustand;
    }

    public String getDatumAb() {
        return DatumAb;
    }

    public String getDatumBis() {
        return DatumBis;
    }

    public String getNiederlassung() {
        return Niederlassung;
    }

    public String getRegionalbereich() {
        return Regionalbereich;
    }

    public String getLetzteAenderung() {
        return LetzteAenderung;
    }

    @Override
    public String toString() {
        return "Betriebsstelle{" +
                "PLC='" + PLC + '\'' +
                ", RL100Code='" + RL100Code + '\'' +
                ", RL100Langname='" + RL100Langname + '\'' +
                ", RL100Kurzname='" + RL100Kurzname + '\'' +
                ", TypKurz='" + TypKurz + '\'' +
                ", TypLang='" + TypLang + '\'' +
                ", Betriebszustand='" + Betriebszustand + '\'' +
                ", DatumAb='" + DatumAb + '\'' +
                ", DatumBis='" + DatumBis + '\'' +
                ", Niederlassung='" + Niederlassung + '\'' +
                ", Regionalbereich='" + Regionalbereich + '\'' +
                ", LetzteAenderung='" + LetzteAenderung + '\'' +
                '}';
    }
}