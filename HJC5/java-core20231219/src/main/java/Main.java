import Tools.Backup;
import Tools.TicTacToe;

public class Main {
    public static void main(String[] args) {
        Backup.backupFiles("./");

        int[] gameState = {1, 2, 0, 2, 1, 0, 1, 0, 2};
        TicTacToe.saveGameState(gameState);
        TicTacToe.printGameState(gameState);
    }
}