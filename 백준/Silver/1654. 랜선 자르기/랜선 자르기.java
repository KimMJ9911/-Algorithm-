import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        /**
         * k = 1 ~ 10_000
         * n = 1 ~ 1_000_000
         * lan = 1 ~ 2^31 - 1
         */
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] lan_cable = new long[k];
        for (int i = 0; i < k; i++) {
            lan_cable[i] = Integer.parseInt(br.readLine());
        }
        //우리가 받아야 하는 값의 범위는 최댓값 + 1 이어야 한다.
            //만일 전체 값이 1이라면 min = 0 , max = 1 이므로 mid = (0 + 1) / 2 = 0으로 ZeroDivisionError가 발생한다.
            //따라서 max + 1을 범위로 잡는다면 해당 오류는 생기지 않는다.
            //최종 mid 값에서 -1만 해준다면 문제는 발생하지 않는다.
        long max = Arrays.stream(lan_cable).max().getAsLong() + 1;
        long min = 0;
        long mid = 0;
        long cnt;
        while (min < max) {
            cnt = 0L;
            mid = (max + min) / 2;

            for (int i = 0; i < lan_cable.length; i++) {
                cnt += lan_cable[i] / mid;
            }

            if (cnt >= n) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        //최대 길이가 나오는 경우 -> min 값이 max 값보다 커지는 경우 이므로
        bw.write((min - 1) + "");
        bw.flush();
        br.close();
        bw.close();
    }
}