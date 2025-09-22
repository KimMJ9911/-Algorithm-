import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n + 1];

            if (n == 1 || n == 2 || n == 3) sb.append(1).append("\n");
            else if (n == 4 || n == 5) sb.append(2).append("\n");
            else {
                arr[1] = 1;
                arr[2] = 1;
                arr[3] = 1;
                arr[4] = 2;
                arr[5] = 2;
                for (int j = 6; j <= n; j++) {
                    arr[j] = arr[j - 5] + arr[j - 1];
                }
                sb.append(arr[n]).append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}