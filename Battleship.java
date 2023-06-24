import java.util.Scanner;

public class Battleship {
    private final int BOARD_SIZE = 5;
    private char[][] board;
    private int numShips;
    
    public Battleship() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        numShips = 3;
    }
    
    public void setupBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    public void printBoard() {
        System.out.println("Game Board:");
        
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public boolean isGameOver() {
        return numShips == 0;
    }
    
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        
        while (!isGameOver()) {
            System.out.println("Enter target coordinates (row column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {
                System.out.println("Invalid coordinates. Please try again.");
                continue;
            }
            
            if (board[row][col] == 'X') {
                System.out.println("Target already hit. Please try again.");
                continue;
            }
            
            if (board[row][col] == 'S') {
                System.out.println("Hit!");
                board[row][col] = 'X';
                numShips--;
            } else {
                System.out.println("Miss!");
                board[row][col] = 'O';
            }
            
            printBoard();
        }
        
        System.out.println("Congratulations! You have sunk all the ships.");
    }
    
    public static void main(String[] args) {
        Battleship game = new Battleship();
        game.setupBoard();
        game.printBoard();
        game.playGame();
    }
}
