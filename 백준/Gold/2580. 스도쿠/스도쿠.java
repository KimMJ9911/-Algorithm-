import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] sudoku;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS();
    }

    private static void DFS() {
        int[] point = findZero();

        if (point == null) {
            print_board();
            System.exit(0);
        }

        int x = point[0];
        int y = point[1];

        for (int i = 1; i <= 9; i++) {
            if (defineValue(x , y , i)) {
                sudoku[x][y] = i;
                DFS();
                sudoku[x][y] = 0;
            }
        }
    }

    private static int[] findZero() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) return new int[] {i , j};
            }
        }
        return null;
    }

    private static boolean defineValue(int x , int y , int val) {
        //세로 줄 검증
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == val) return false;
        }

        //가로 줄 검증
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] == val) return false;
        }

        int org_x = (x / 3) * 3;
        int org_y = (y / 3) * 3;

        for (int i = org_x; i < org_x + 3; i++) {
            for (int j = org_y; j < org_y + 3; j++) {
                if (sudoku[i][j] == val) return false;
            }
        }
        return true;
    }

    private static void print_board() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

}