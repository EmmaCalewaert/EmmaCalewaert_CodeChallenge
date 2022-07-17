package application.dao;

import application.database.CSVData;
import application.exception.BetriebsstelleNotFoundException;
import application.model.Betriebsstelle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BetriebsstelleDAO implements IBetriebsstelleDAO {

    public BetriebsstelleDAO() {  }

    @Override
    public Betriebsstelle getBetriebsstelleByAbbreviation(String abbreviation) throws BetriebsstelleNotFoundException {
        return CSVData.getInstance().getData(abbreviation);
    }

    @Override
    public String getBetriebsstelleByAbbreviationAsJSON(String abbreviation) throws BetriebsstelleNotFoundException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(getBetriebsstelleByAbbreviation(abbreviation));
    }
}