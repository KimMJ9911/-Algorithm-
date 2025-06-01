import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i] , '*');
        }

        for (int i = 1; i < n; i *= 3) {
            pattern_match(i);
        }

        for (char[] chars : board) {
            for (char c : chars) {
                bw.write(c + "");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static void pattern_match(int init) {
        for (int i = init; i < n; i += init * 3) {
            for (int j = init; j < n; j += init * 3) {
                for (int k = i; k < i + init; k++) {
                    for (int l = j; l < j + init; l++) {
                        board[k][l] = ' ';
                    }
                }
            }
        }
    }
}