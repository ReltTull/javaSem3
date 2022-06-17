
import java.util.Scanner;

public class horsesAllBoard {

    class KnightMove {
        static int[][] board;
        static int[][] moves;
        static int maxMoves;

        public static void main(String[] args) {
            board = new int[5][5];
            maxMoves = board.length * board[0].length;
            moves = new int[][] { { -2, 1 }, { -2, -1 }, { 2, 1 }, { 2, -1 }, { -1, -2 }, { -1, -2 }, { 1, 2 },
                    { 1, -2 } };
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (findPath(i, j, 1)) {
                        printSol();
                        System.out.println("------");
                        board = new int[5][5];
                    }
                }
            }
            System.out.println("No solution");
        }

        static boolean findPath(int curX, int curY, int moveNum) {
            board[curX][curY] = moveNum;
            if (moveNum >= maxMoves)
                return true;

            for (int i = 0; i < 8; i++) {
                int nextX = curX + moves[i][0];
                int nextY = curY + moves[i][1];
                if (isPossibleMove(nextX, nextY) && findPath(nextX, nextY, moveNum + 1)) {
                    return true;
                }
            }
            board[curX][curY] = 0;
            return false;
        }

        static boolean isPossibleMove(int x, int y) {
            return x >= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] == 0;
        }

        static void printSol () {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.println(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

}

// scanner решение

// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// int rowsCount = scanner.nextInt(),
// colsCount = scanner.nextInt();
// if (rowsCount <= 0 || colsCount <= 0) {
// System.out.println("Invalid parameters");
// return;
// }
// System.out.printf("Count of routes: %d", CountOfRoutes(1, 1, rowsCount,
// colsCount));
// }

// /**
// * @param x Текущая координата коня X (начальная = 1)
// * @param y Текущая координата коня Y (начальная = 1)
// * @param fieldRows Число строк поля
// * @param fieldCols Число столбцов поля
// * @return Количество маршрутов из левого верхнего угла поля в правый нижний
// */
// static int CountOfRoutes(int x, int y, final int fieldRows, final int
// fieldCols) {
// if (x == fieldCols && y == fieldRows)
// return 1;
// if (x < fieldCols && y < fieldRows)
// return CountOfRoutes(x + 2, y + 1, fieldRows, fieldCols)
// + CountOfRoutes(x + 1, y + 2, fieldRows, fieldCols);
// else
// return 0;
// }