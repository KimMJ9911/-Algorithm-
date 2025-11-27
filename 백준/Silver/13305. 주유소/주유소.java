import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] city = new int[n];
        int[] road = new int[n - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long curr_cost = Long.MAX_VALUE;
        long total_cost = 0L;
        //마지막 도시에선 주유할 필요가 없기 때문에
        for (int i = 0; i < n - 1; i++) {
            curr_cost = Math.min(curr_cost , city[i]);
            total_cost += curr_cost * road[i];
        }

        bw.write(String.valueOf(total_cost));
        bw.flush();
        br.close();
        bw.close();
    }
}