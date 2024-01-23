package Tools;

import java.io.*;

public class TicTacToe {
    public static void saveGameState(int[] gameState) {
        if (gameState.length != 9) {
            System.out.println("Неверная длина массива.");
            return;
        }

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("GameSave.dat"))) {
            int compressedState = 0;
            for (int i = 0; i < gameState.length; i++) {
                compressedState |= (gameState[i] & 0x03) << (2 * i);
            }

            dos.writeByte((compressedState >>> 16) & 0xFF);
            dos.writeByte((compressedState >>> 8) & 0xFF);
            dos.writeByte(compressedState & 0xFF);

            System.out.println("Игра сохранена в файл GameSave.dat");
        } catch (IOException e) {
            System.out.println("Не удалось сохранить.");
        }
    }


    //сделал печать в терминале чтоб было удобно смотреть за выводом данных
    public static void printGameState(int[] gameState) {
        if (gameState.length != 9) {
            System.out.println("Неверная длина массива.");
            return;
            }
    
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char symbol;
                switch (gameState[row * 3 + col]) {
                    case 1: symbol = 'X'; break;
                    case 2: symbol = 'O'; break;
                    case 3: symbol = '#'; break;
                    default: symbol = '.'; break;
                }
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}
