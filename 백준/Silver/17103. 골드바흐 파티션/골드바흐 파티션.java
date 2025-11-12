import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] valid;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max , arr[i]);
        }

        valid = new boolean[max + 1];
        isPrime(max);

        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (valid[i]) prime.add(i);
        }

        for (int i : arr) {
            int cnt = 0;
            for (int next : prime) {
                if ((next <= i / 2) && valid[next] && valid[i - next]) cnt++;
            }
            sb.append(cnt).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void isPrime(int max) {
        Arrays.fill(valid , true);

        valid[0] = false;
        valid[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (valid[i]) {
                for (int j = i * i; j <= max; j += i) {
                    valid[j] = false;
                }
            }
        }
    }
}