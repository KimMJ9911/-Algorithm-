import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static int[][] arr;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0 , 0 , n);

        bw.write(cnt_u1 + "\n" + cnt_0 + "\n" + cnt_1);
        bw.flush();
        br.close();
        bw.close();
    }
    static int cnt_u1 = 0 , cnt_0 = 0 , cnt_1 = 0;

    private static void solution(int x , int y , int k) {
        boolean flag = false;
        int init = arr[x][y];
        for (int i = x; i < x + k; i++) {
            for (int j = y; j < y + k; j++) {
                if (arr[i][j] != init) {
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        if (!flag) {
            if (init == 1) cnt_1++;
            else if (init == 0) cnt_0++;
            else cnt_u1++;
        } else {
            IntStream.rangeClosed(0 , 2).forEach(i -> {
                IntStream.rangeClosed(0 , 2).forEach(j -> {
                    solution(x + i * k / 3 , y + j * k / 3 , k / 3);
                });
            });
        }
    }
}