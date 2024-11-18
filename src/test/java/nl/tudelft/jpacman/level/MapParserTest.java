package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.npc.ghost.Blinky;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * This is a test class for MapParser.
 */
@ExtendWith(MockitoExtension.class)
public class MapParserTest {
    @Mock
    private BoardFactory boardFactory;
    @Mock
    private LevelFactory levelFactory;
    @Mock
    private Blinky blinky;

    /**
     * Test for the parseMap method (good map).
     */
    @Test
    public void testParseMapGood() {
//        MockitoAnnotations MockitoAnnotations;
        MockitoAnnotations.initMocks(this);
        assertNotNull(boardFactory);
        assertNotNull(levelFactory);
        Mockito.when(levelFactory.createGhost()).thenReturn(blinky);
        MapParser mapParser = new MapParser(levelFactory, boardFactory);
        ArrayList<String> map = new ArrayList<>();
        map.add("############");
        map.add("#P        G#");
        map.add("############");
        mapParser.parseMap(map);

        // Verifications
        Mockito.verify(levelFactory, Mockito.times(1))
            .createGhost();
    }

//
//        // Expect PacmanConfigurationException
//        assertThrows(PacmanConfigurationException.class, () -> mapParser.parseMap(map));
//    }

    /**
     * Test for the parseMap method (bad map).
     */
    @Test
    public void testParseMapWrong1() {
        PacmanConfigurationException thrown =
            Assertions.assertThrows(PacmanConfigurationException.class, () -> {
                MockitoAnnotations.initMocks(this);
                assertNotNull(boardFactory);
                assertNotNull(levelFactory);
                Mockito.when(levelFactory.createGhost()).thenReturn(blinky);
                MapParser mapParser = new MapParser(levelFactory, boardFactory);

                // Create a map with unexpected characters
                ArrayList<String> map = new ArrayList<>();
                map.add("############");
                map.add("#P              G#");
                map.add("############");

                // Call parseMap with invalid map
                mapParser.parseMap(map);
            });

        // Check the exception message to ensure it provides useful information
        Assertions.assertEquals("Map contains unexpected characters", thrown.getMessage());
    }

}
