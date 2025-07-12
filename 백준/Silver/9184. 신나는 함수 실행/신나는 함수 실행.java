import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][][] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        table = new int[21][21][21];

        while (true) {
            st = new StringTokenizer(br.readLine() , " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + func(a , b , c));
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static int func(int a , int b , int c) {
        if (inRange(a , b , c) && table[a][b][c] != 0) return table[a][b][c];

        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (a > 20 || b > 20 || c > 20) {
            return table[20][20][20] = func(20 , 20 , 20);
        }

        if (a < b && b < c) {
            return table[a][b][c] = func(a , b , c - 1) + func(a , b - 1 , c - 1) - func(a , b - 1 , c);
        }

        return table[a][b][c] = func(a - 1 , b , c) + func(a - 1 , b - 1 , c) + func(a - 1 , b , c - 1)  - func(a - 1 , b - 1 , c - 1);
    }

    static boolean inRange(int a , int b , int c) {
        return a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20;
    }
}