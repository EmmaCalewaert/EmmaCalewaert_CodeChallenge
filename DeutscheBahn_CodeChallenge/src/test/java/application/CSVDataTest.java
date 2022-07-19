package application;

import application.database.CSVData;
import application.exception.BetriebsstelleNotFoundException;
import application.model.Betriebsstelle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVDataTest {
    @Test
    void getInstance() {
        CSVData data = CSVData.getInstance();
        assertNotNull(data);
    }

    @Test
    void getDataExistingStelle() {
        CSVData data = CSVData.getInstance();
        Betriebsstelle testStelle = new Betriebsstelle("DE14378", "AAMP", "Hamburg Anckelmannsplatz", "Anckelmannsplatz", "ÜST", "Üst", "Betrieb", "20200401", "", "2", "Nord", "20201029");
        assertDoesNotThrow(() ->  {
            Betriebsstelle stelle = data.getData("aamp");
            assertEquals(stelle, testStelle);
        });
    }

    @Test
    void getDataNoStelle() {
        CSVData data = CSVData.getInstance();
        assertThrows(BetriebsstelleNotFoundException.class, () -> data.getData("notexist"));
    }
}