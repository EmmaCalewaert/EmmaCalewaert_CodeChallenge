package application.dao;

import application.exception.BetriebsstelleNotFoundException;
import application.model.Betriebsstelle;

public interface IBetriebsstelleDAO {
    Betriebsstelle getBetriebsstelleByAbbreviation (String abbreviation) throws BetriebsstelleNotFoundException;

    String getBetriebsstelleByAbbreviationAsJSON (String abbreviation) throws BetriebsstelleNotFoundException;
}
