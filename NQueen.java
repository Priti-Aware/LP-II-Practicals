import java.util.Scanner;

public class NQueen{
    static int N;
    static int[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of queens: ");
        N = scanner.nextInt();

        board = new int[N][N];
        System.out.println("Board Before Placing queens");
        printBoard();

        if (solveNQueens(0)) {
            System.out.println("Board after Placing queens");
            printBoard();
        } else {
            System.out.println("Can't Place");
        }
    }

    static boolean solveNQueens(int col) {
        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (solveNQueens(col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int row, int col) {
        // Check if there is a queen in the same column
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// C:\Users\Priti\Desktop\6thSem\LAB-II\codes\TE_B_07_Priti_Aware>javac NQueen.java

// C:\Users\Priti\Desktop\6thSem\LAB-II\codes\TE_B_07_Priti_Aware>java NQueen
// Enter number of queens: 4
// Board Before Placing queens
// 0 0 0 0
// 0 0 0 0
// 0 0 0 0
// 0 0 0 0
// Board after Placing queens
// 0 0 1 0
// 1 0 0 0
// 0 0 0 1
// 0 1 0 0