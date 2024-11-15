package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */
public class DirectionTest {

    /**
     * Test if the delta values for NORTH direction are correct.
     * North should have a deltaY of -1 and deltaX of 0.
     */
    @Test
    void testNorth() {
        Direction north = Direction.valueOf("NORTH");
        assertThat(north.getDeltaY()).isEqualTo(-1);
        assertThat(north.getDeltaX()).isEqualTo(0);
    }

    /**
     * Test if the delta values for SOUTH direction are correct.
     * South should have a deltaY of 1 and deltaX of 0.
     */
    @Test
    void testSouth() {
        Direction south = Direction.valueOf("SOUTH");
        assertThat(south.getDeltaY()).isEqualTo(1);
        assertThat(south.getDeltaX()).isEqualTo(0);
    }

    /**
     * Test if the delta values for EAST direction are correct.
     * East should have a deltaY of 0 and deltaX of 1.
     */
    @Test
    void testEast() {
        Direction east = Direction.valueOf("EAST");
        assertThat(east.getDeltaY()).isEqualTo(0);
        assertThat(east.getDeltaX()).isEqualTo(1);
    }

    /**
     * Test if the delta values for WEST direction are correct.
     * West should have a deltaY of 0 and deltaX of -1.
     */
    @Test
    void testWest() {
        Direction west = Direction.valueOf("WEST");
        assertThat(west.getDeltaY()).isEqualTo(0);
        assertThat(west.getDeltaX()).isEqualTo(-1);
    }
}
