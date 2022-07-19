package application.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        this.TypKurz = typKurz;
        this.TypLang = typLang;
        this.Betriebszustand = betriebszustand;
        this.DatumAb = datumAb;
        this.DatumBis = datumBis;
        this.Niederlassung = niederlassung;
        this.Regionalbereich = regionalbereich;
        this.LetzteAenderung = letzteAenderung;
    }

    private final static int NUM_TO_PARSE = 12;
    public Betriebsstelle(String[] line) throws DataFormatException {
        if(line.length != NUM_TO_PARSE) throw new DataFormatException(String.format("Data length incorrect! Should have %d strings to parse.", NUM_TO_PARSE));
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
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) return false;
        final Betriebsstelle other = (Betriebsstelle) obj;
        return other.PLC.equals(this.PLC) && other.RL100Code.equals(RL100Code) && other.RL100Langname.equals(RL100Langname)
                && other.RL100Kurzname.equals(RL100Kurzname) && other.TypKurz.equals(TypKurz) && other.TypLang.equals(TypLang)
                && other.Betriebszustand.equals(Betriebszustand) && other.DatumAb.equals(DatumAb) && other.DatumBis.equals(DatumBis)
                && other.Niederlassung.equals(Niederlassung) && other.Regionalbereich.equals(Regionalbereich)
                && other.LetzteAenderung.equals(LetzteAenderung);
    }

    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}