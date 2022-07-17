package application.dao;

import application.exception.BetriebsstelleNotFoundException;
import application.model.Betriebsstelle;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IBetriebsstelleDAO {
    public Betriebsstelle getBetriebsstelleByAbbreviation (String abbreviation) throws BetriebsstelleNotFoundException;

    public String getBetriebsstelleByAbbreviationAsJSON (String abbreviation) throws BetriebsstelleNotFoundException, JsonProcessingException;

}
