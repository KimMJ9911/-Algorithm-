import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] square = new int[100][100];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            IntStream.range(0 , 10).forEach(j -> {
                IntStream.range(0 , 10).forEach(k -> {
                    square[y + k][x + j] = 1;
                });
            });
        }

        int sum = 0;
        for (int[] p : square) {
            for (int i : p) {
                sum += i;
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();
    }
}