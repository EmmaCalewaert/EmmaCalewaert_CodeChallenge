package application.database;

import application.exception.BetriebsstelleNotFoundException;
import application.model.Betriebsstelle;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;

public class CSVData {
    private static CSVData instance = null;
    private static final String CSV_FILENAME = "DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv";
    Map<String, Betriebsstelle> data = new HashMap<String, Betriebsstelle>();
    Logger logger = Logger.getLogger(this.getClass().getName());


    private CSVData() {
        logger.setLevel(Level.WARNING);
        try {
            readData();
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
            e.printStackTrace();
        }
    }

    public static CSVData getInstance() {
        if (instance == null) {
            instance = new CSVData();
        }
        return instance;
    }

    private void readData() throws FileNotFoundException {
        Scanner sc = null;
        InputStream file = this.getClass().getClassLoader().getResourceAsStream(CSV_FILENAME);
        if (file == null) throw new FileNotFoundException(String.format("File %s not found!", CSV_FILENAME));

        sc = new Scanner(file, StandardCharsets.UTF_8); // UTF-8 to account for special German characters
        sc.nextLine(); // skip header line

        int counter = 1;
        while(sc.hasNextLine()) {
            try {
                enterDataLine(sc.nextLine().split(";")); // data is split by ;
                counter++;
            } catch (DataFormatException e) {
                e.printStackTrace();
                logger.log(Level.WARNING, String.format("Failed to add line %d!", counter));
            }
        }
        logger.log(Level.INFO, String.format("Added %d lines", counter));
        sc.close();
    }

    private void enterDataLine(String[] line) throws DataFormatException {
        data.put(line[1], new Betriebsstelle(line));
        logger.log(Level.INFO, String.format("Added Betriebstelle %s", line[1]));
    }

    public Betriebsstelle getData(String betriebstelle) throws BetriebsstelleNotFoundException {
        Betriebsstelle betriebsstelle = data.get(betriebstelle.toUpperCase());
        if(betriebsstelle == null) throw new BetriebsstelleNotFoundException();
        return betriebsstelle;
    }
}

