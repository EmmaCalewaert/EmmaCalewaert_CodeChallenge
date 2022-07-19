package application;

import application.controllers.BetriebsstelleController;
import application.dao.BetriebsstelleDAO;
import application.model.Betriebsstelle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BetriebsstelleControllerTest {
    private MockMvc mockMvc;

    @BeforeAll
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new BetriebsstelleController(new BetriebsstelleDAO())).build();
    }

    @Test
    void getBetriebsstelleExists() throws Exception {
        Betriebsstelle testStelle = new Betriebsstelle("DE14378", "AAMP", "Hamburg Anckelmannsplatz", "Anckelmannsplatz", "ÜST", "Üst", "Betrieb", "20200401", "", "2", "Nord", "20201029");
        String content = mockMvc.perform(get("/betriebsstelle/aamp"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse()
                .getContentAsString(StandardCharsets.UTF_8);
        assertEquals(content, testStelle.toJson());
    }

    @Test
    void getBetriebsstelleNotExists() throws Exception {
        mockMvc.perform(get("/betriebsstelle/notexist"))
                .andExpect(status().isNotFound());
    }
}
