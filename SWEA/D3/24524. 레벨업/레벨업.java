import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] path = new int[n];
            st = new StringTokenizer(br.readLine() , " ");
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                path[j] = val;
            }
            int total_length = 0;
            for (int j = 1; j < n; j++) {
                total_length += Math.abs(path[j] - path[j - 1]);
            }

            bw.write(get_min_path(path , total_length) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int get_min_path(int[] path , int total) {
        //각 좌표 중 하나를 미방문으로 지정
        int MIN_PATH = Integer.MAX_VALUE;
        //1번 째 정점과 마지막 정점은 무조건 방문해야 함
        for (int i = 1; i < path.length - 1; i++) {
            int cal = total;
            cal += Math.abs(path[i + 1] - path[i - 1])
                    - Math.abs(path[i + 1] - path[i])
                    - Math.abs(path[i] - path[i - 1]);
            MIN_PATH = Math.min(cal , MIN_PATH);
        }

        return MIN_PATH;
    }
}