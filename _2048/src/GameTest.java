import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {


    //Note that I'm testing for edge cases, not general unit tests here, as I've played
    //2048 for quite a bit, so it's more efficient in this case to test through printing the array out


    public void leftBasic() {
        Game game = new Game();
        game.gameBoard[0][1].value = 2;
        game.gameBoard[0][3].value = 2;
        game.left();
        int firstRow[] = {4, 0, 0, 0};
        assertArrayEquals(firstRow, game.getArray()[0]);
    }


    //chance of multiple being combined, shouldn't
    @Test
    public void leftMultipleBait() {
        Game game = new Game();
        game.gameBoard[0][0].value = 2;
        game.gameBoard[0][1].value = 2;
        game.gameBoard[0][2].value = 4;
        game.left();
        int firstRow[] = {4, 4, 0, 0};
        assertArrayEquals(firstRow, game.getArray()[0]);
    }

    @Test
    public void upBasic() {
        Game game = new Game();
        game.gameBoard[0][0].value = 2;
        game.gameBoard[1][0].value = 2;
        game.up();
        assertEquals(4, game.gameBoard[0][0].value);
    }

    @Test
    public void updateScore() {
        Game game = new Game();
        game.gameBoard[0][0].value = 2;
        game.gameBoard[1][0].value = 2;
        game.up();
        assertEquals((Integer) 4, game.score);
    }
}