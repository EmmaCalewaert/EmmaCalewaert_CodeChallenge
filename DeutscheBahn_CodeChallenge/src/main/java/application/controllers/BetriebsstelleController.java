package application.controllers;

import application.dao.IBetriebsstelleDAO;
import application.exception.BetriebsstelleNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/betriebsstelle")
public class BetriebsstelleController {
    private final IBetriebsstelleDAO betriebsstelleDAO;
    public BetriebsstelleController(IBetriebsstelleDAO betriebsstelleDAO) {
        this.betriebsstelleDAO = betriebsstelleDAO;
    }

    @GetMapping(path = "/{abbreviation}", produces = "application/json")
    ResponseEntity<String> getBetriebsstelle(@PathVariable(value = "abbreviation") String abbreviation) {
        try {
            return new ResponseEntity<String>(betriebsstelleDAO.getBetriebsstelleByAbbreviationAsJSON(abbreviation), HttpStatus.OK);
        } catch (BetriebsstelleNotFoundException e) {
            return new ResponseEntity<String>(String.format("No Betriebsstelle %s found", abbreviation), HttpStatus.NOT_FOUND);
        }
    }
}
