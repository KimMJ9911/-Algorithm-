import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] time_table = new int[n][2];

        //시작 시간과 종료 시간을 담은 배열
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            time_table[i][0] = Integer.parseInt(st.nextToken());
            time_table[i][1] = Integer.parseInt(st.nextToken());
        }

        //끝나는 시간을 기준으로 배열을 정렬하가
        Arrays.sort(time_table, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });


        int prv_time_set = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (prv_time_set <= time_table[i][0]) {
                prv_time_set = time_table[i][1];
                ans++;
            }
        }

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
}