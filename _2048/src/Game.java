import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    tile[][] gameBoard;
    Integer score;
    Boolean won;
    Boolean triggerWin;
    Boolean lost = false;
    Game() {
        won = Boolean.FALSE;
        triggerWin = Boolean.FALSE;
        gameBoard = new tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameBoard[i][j] = new tile(0);
            }
        }
        score = 0;
    }

    boolean left() {
        Game nextGame = new Game();
        tile[][] newBoard = nextGame.gameBoard;
        tile[][] gameboard = this.gameBoard;
        for (int y = 0; y < 4; y++) {
            int index = 0;
            //keeps track of where the next value should be, since everything is kept left most
            for (int x = 0; x < 4; x++) {
                if (gameboard[y][x].value != 0) {
                    if (index > 0 && gameboard[y][x].value == newBoard[y][index - 1].value && !newBoard[y][index - 1].merged) {
                        newBoard[y][index - 1].value *= 2;
                        score += newBoard[y][index - 1].value;
                        newBoard[y][index - 1].merged = true;
                    } else {
                        newBoard[y][index] = gameboard[y][x];
                        index++;
                    }
                }
            }
        }
        boolean continuer = false;
        for (int i = 0; i < 4; i++) {
            if (!won) {
                for (int j:
                        this.getArray()[i]) {
                    if (j == 2048) {

                        triggerWin = Boolean.TRUE;
                        System.out.println("You've Won!");
                    }
                }
            } else {
                triggerWin = Boolean.FALSE;
            }

            //if any row isn't equal, we've updated
            if (!Arrays.equals(this.gameBoard[i], newBoard[i])) {
                continuer = true;
            }

        }
        if (triggerWin) {
            won = true;
        }
        this.gameBoard = newBoard;
        this.resetMerged();
        return continuer;
    }

    boolean right() {
        Game nextGame = new Game();
        tile[][] newBoard = nextGame.gameBoard;
        tile[][] gameboard = this.gameBoard;
        for (int y = 0; y < 4; y++) {
            int index = 3;
            //keeps track of where the next value should be, since everything is kept left most
            for (int x = 3; x > -1; x--) {
                if (gameboard[y][x].value != 0) {
                    if (index < 3 && gameboard[y][x].value == newBoard[y][index + 1].value && !newBoard[y][index + 1].merged) {
                        newBoard[y][index + 1].value *= 2;
                        score += newBoard[y][index + 1].value;
                        newBoard[y][index + 1].merged = true;
                    } else {
                        newBoard[y][index] = gameboard[y][x];
                        index--;
                    }
                }
            }
        }
        boolean continuer = false;
        for (int i = 0; i < 4; i++) {
            if (!won) {
                for (int j:
                        this.getArray()[i]) {
                    if (j == 2048) {

                        triggerWin = Boolean.TRUE;
                        System.out.println("You've Won!");
                    }
                }
            } else {
                triggerWin = Boolean.FALSE;
            }

            //if any row isn't equal, we've updated
            if (!Arrays.equals(this.gameBoard[i], newBoard[i])) {
                continuer = true;
            }

        }
        if (triggerWin) {
            won = Boolean.TRUE;
        }
        this.gameBoard = newBoard;
        this.resetMerged();
        return continuer;
    }
    boolean up() {
        Game nextGame = new Game();
        tile[][] newBoard = nextGame.gameBoard;
        tile[][] gameboard = this.gameBoard;
        for (int y = 0; y < 4; y++) {
            int index = 0;
            //keeps track of where the next value should be, since everything is kept left most
            for (int x = 0; x < 4; x++) {
                if (gameboard[x][y].value != 0) {
                    if (index > 0 && gameboard[x][y].value == newBoard[index - 1][y].value && !newBoard[index - 1][y].merged) {
                        newBoard[index - 1][y].value *= 2;
                        score += newBoard[index - 1][y].value;
                        newBoard[index - 1][y].merged = true;
                    } else {
                        newBoard[index][y] = gameboard[x][y];
                        index++;
                    }
                }
            }
        }
        boolean continuer = false;
        for (int i = 0; i < 4; i++) {
            if (!won) {
                for (int j:
                        this.getArray()[i]) {
                    if (j == 2048) {

                        triggerWin = Boolean.TRUE;
                        System.out.println("You've Won!");
                    }
                }
            } else {
                triggerWin = Boolean.FALSE;
            }

            //if any row isn't equal, we've updated
            if (!Arrays.equals(this.gameBoard[i], newBoard[i])) {
                continuer = true;
            }
            // if we've reached the third row, and they're still equal, nothing updated

        }
        if (triggerWin) {
            won = Boolean.TRUE;
        }
        this.gameBoard = newBoard;
        this.resetMerged();
        return continuer;
    }
    boolean down() {
        Game nextGame = new Game();
        tile[][] newBoard = nextGame.gameBoard;
        tile[][] gameboard = this.gameBoard;
        for (int y = 0; y < 4; y++) {
            int index = 3;
            //keeps track of where the next value should be, since everything is kept left most
            for (int x = 3; x > -1; x--) {
                if (gameboard[x][y].value != 0) {
                    if (index < 3 && gameboard[x][y].value == newBoard[index + 1][y].value && !newBoard[index + 1][y].merged) {
                        newBoard[index + 1][y].value *= 2;
                        score += newBoard[index + 1][y].value;
                        newBoard[index + 1][y].merged = true;
                    } else {
                        newBoard[index][y] = gameboard[x][y];
                        index--;
                    }
                }
            }
        }
        boolean continuer = false;
        for (int i = 0; i < 4; i++) {

            if (!won) {
                for (int j:
                        this.getArray()[i]) {
                    if (j == 2048) {
                        triggerWin = Boolean.TRUE;
                        System.out.println("You've Won!");
                    }
                }
            } else {
                triggerWin = Boolean.FALSE;
            }

            //if any row isn't equal, we've updated
            if (!Arrays.equals(this.gameBoard[i], newBoard[i])) {
                continuer = true;
            }


        }
        if (triggerWin) {
            won = true;
        }
        this.gameBoard = newBoard;
        this.resetMerged();
        return continuer;
    }

    void resetMerged() {
        tile[][] gameBoard = this.gameBoard;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                gameBoard[i][j].merged = false;
            }
        }
    }

    //will return true if there's no more empty spots subsequently
    boolean generateTile() {
        int[][] gameBoard = this.getArray();
        ArrayList<position> possiblePositions = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameBoard[i][j] == 0) {
                    possiblePositions.add(new position(i, j));
                }
            }
        }
        position newPos = possiblePositions.get((int) (Math.random() * (possiblePositions.size())));
        int newValue = (int) (Math.random() * (10));
        if (newValue == 9) {
            newValue = 4;
        } else {
            newValue = 2;
        }
        this.gameBoard[newPos.x][newPos.y].value = newValue;
        this.gameBoard[newPos.x][newPos.y].merged = false;

        return (possiblePositions.size() == 1);
    }

    boolean gameContinue() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    if (this.getArray()[i][j] == this.getArray()[i][j+1]) {
                        return true;
                    } } catch (Exception ignore) {}
                try {
                    if (this.getArray()[i][j] == this.getArray()[i][j-1]) {
                        return true;
                    } } catch (Exception ignore) {}
                try {
                    if (this.getArray()[i][j] == this.getArray()[i + 1][j]) {
                        return true;
                    } } catch (Exception ignore) {}
                try {
                    if (this.getArray()[i][j] == this.getArray()[i - 1][j]) {
                        return true;
                    } } catch (Exception ignore) {}
                }
            }

        return false;
    }


    void resetGame() {
        Game newGame = new Game();
        this.score = 0;
        this.gameBoard = newGame.gameBoard;
        this.triggerWin = Boolean.FALSE;
        this.won = Boolean.FALSE;
    }
    int[][] getArray() {
        int[][] returner = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                returner[i][j] = this.gameBoard[i][j].value;
            }
        }
        return returner;
    }
    class tile {
        boolean merged;
        int value;
        tile(int value) {
            this.value = value;
            this.merged = false;
        }
        tile() {
            this.value = 0;
            this.merged = false;
        }
        tile(boolean merged, int value) {
            this.value = value;
            this.merged = merged;
        }

        @Override
        public boolean equals(Object obj) {
            if (this.getClass() != obj.getClass()) {
                return false;
            }
            return this.value == ((tile) obj).value;
        }


    }
    public class position {
        int x;
        int y;
        position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
