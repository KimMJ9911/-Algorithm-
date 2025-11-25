import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        Map<Integer , Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            sorted[i] = val;
        }

        Arrays.sort(sorted);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sorted[i])) {
                map.put(sorted[i] , idx);
                idx++;
            }
        }

        for (int i : arr) {
            sb.append(map.get(i)).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}