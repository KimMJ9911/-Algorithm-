import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            List<Integer> arr = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    arr.add(i);
                    sum += i;
                }
            }

            if (sum == n) {
                sb.append(n).append(" = ");
                for (Integer i : arr) {
                    if (arr.get(arr.size() - 1) == i) sb.append(i);
                    else sb.append(i).append(" + ");
                }
                sb.append("\n");
            } else sb.append(n).append(" is NOT perfect.").append("\n");
        }

        
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}