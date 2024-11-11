package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.catchThrowable;

/**
 * Test suite for the Board class.
 */
class BoardTest {

    private Board board;
    private Square[][] grid;

    /**
     * Set up a new Board instance before each test.
     * Initializes a 1x1 grid with a BasicSquare.
     */
    @BeforeEach
    void setUp() {
        // Create a 1x1 grid with a BasicSquare
        grid = new Square[1][1];
        grid[0][0] = new BasicSquare(); // Assuming BasicSquare is a valid class
        board = new Board(grid);
    }

    /**
     * Test if the board is not null after being created.
     */
    @Test
    void boardShouldNotBeNull() {
        // Test if the board is not null
        assertThat(board).isNotNull();
    }

    /**
     * Test if the board's width and height match the expected values.
     */
    @Test
    void testBoardDimensions() {
        // Test if the board dimensions are correct
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
    }

    /**
     * Test if the square at position (0, 0) is not null.
     */
    @Test
    void testSquareAtPosition() {
        // Test if the square at position (0, 0) is not null
        Square square = board.squareAt(0, 0);
        assertThat(square).isNotNull();
    }

    /**
     * Test if an exception is thrown when the grid contains a null square.
     */
    @Test
    void testBoardWithNullSquare() {
        // Create a new board with a null square
        grid = new Square[1][1];
        grid[0][0] = null;
        Throwable thrown = catchThrowable(() -> {
            board = new Board(grid);
        });

        // Verify that the exception is thrown
        assertThat(thrown).isInstanceOf(AssertionError.class)
            .hasMessageContaining("Initial grid cannot contain null squares");
    }
}
