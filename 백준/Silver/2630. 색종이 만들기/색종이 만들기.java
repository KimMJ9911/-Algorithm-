import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int cnt_Zero , cnt_One;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt_Zero = 0;
        cnt_One = 0;
        getSquare(1 , 1, n);

        bw.write(cnt_Zero + "\n" + cnt_One);
        bw.flush();
        br.close();
        bw.close();
    }
    static void getSquare(int x , int y , int size) {
        if (size == 0) return;

        int sum = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                sum += board[i][j];
            }
        }

        if (sum == 0) {
            cnt_Zero++;
        }
        else if (sum == size * size) {
            cnt_One++;
        }
        else {
            getSquare(x , y , size / 2);
            getSquare(x + size / 2 , y , size / 2);
            getSquare(x , y + size / 2 , size / 2);
            getSquare(x + size / 2 , y + size / 2 , size / 2);
        }
    }
}