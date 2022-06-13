
// import java.util.Scanner;

public class horsesAllBoard {


    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0 }, };

        knightMove(board, 0, 0, 1, 1);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    static int GlobalmoveCount;

    // проверка, есть ли возможность совершить ход в непройденную раннее клетку (то
    // есть, значение которой больше нуля)

    public static boolean checkAvaliableMoves(int[][] desk, int row, int col) {

        if (desk[row - 1][col - 2] > 0 && desk[row - 2][col - 1] > 0 && desk[row - 1][col + 2] > 0
            && desk[row - 2][col + 1] > 0 && desk[row + 1][col + 2] > 0 && desk[row + 2][col + 1]
            > 0 && desk[row + 1][col - 2] > 0 && desk[row + 2][col - 1] > 0) {
                            return false;
                        }
 
        return true;
    }

    // проверка, находятся ли координаты в пределах длины доски

    public static boolean checkUpAfterMove(int[][] desk, int row, int col) {
        if (row < 0 || row >= desk.length - 1 || col < 0 || col >= desk.length - 1) {
            return false;
        }
        if (desk[row][col] > 0) {
                return false;
            }    
        return true;
    }
    

    public static void knightMove(int[][] desk, int r, int c, int rUpdate, int cUpdate) {
        if (checkAvaliableMoves(desk, r, c) == false) {
            desk[r][c] = 0;
            GlobalmoveCount -= 1;
            knightMove(desk, r, c, 0, 0);
        }

        if (checkAvaliableMoves(desk, r, c) == true) {

            if (r + rUpdate < 0 && r + rUpdate > desk.length && c + cUpdate < 0 && c + cUpdate > desk.length) {
                desk[r][c] = 0;
                GlobalmoveCount -= 1;
                knightMove(desk, r, c, 0, 0);
            }

            if (checkUpAfterMove(desk, r + rUpdate, c + cUpdate)) {
                desk[r][c] = GlobalmoveCount;
                GlobalmoveCount += 1;
                desk[r][c] = desk[r + rUpdate][c + cUpdate];
            // сделать так, чтобы после возврата не совершался один и тот же ход
            } else {
                if (checkUpAfterMove(desk, r - 2, c - 1)) {
                    knightMove(desk, r, c, -2, -1);
                }
                if (checkUpAfterMove(desk, r - 1, c - 2)) {
                    knightMove(desk, r, c, -1, -2);
                }
                if (checkUpAfterMove(desk, r - 2, c + 1)) {
                    knightMove(desk, r, c, -2, 1);
                }
                if (checkUpAfterMove(desk, r - 1, c + 2)) {
                    knightMove(desk, r, c, -1, 2);
                }
                if (checkUpAfterMove(desk, r + 2, c + 1)) {
                    knightMove(desk, r, c, 2, 1);
                }
                if (checkUpAfterMove(desk, r + 1, c + 2)) {
                    knightMove(desk, r, c, +1, 2);
                }
                if (checkUpAfterMove(desk, r - 2, c + 1)) {
                    knightMove(desk, r, c, -2, 1);
                }
                if (checkUpAfterMove(desk, r - 1, c + 2)) {
                    knightMove(desk, r, c, -1, 2);
                }
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
