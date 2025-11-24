import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N * N 배열에서 각 배열의 수들은 i 행의 배수로 표현할 수 있다, -> i * 1 , i * 2 , i * 3 , ...
        //각 행의 수들은  1 <= k <= N / N <= k <= 2N / ... 으로 표현할 수 있다.
            //이 말은 각 수들은 idx 값 k 보다 무조건 작다는 말과 같다.
        //즉, 기준이 되는 인덱스 값 (mid) 보다 작은 수들의 갯수가 k - 1 개일 때와 같다는 말이다.

        //mid 갯수를 이분탐색으로 조정해 가면서 작은 수의 갯수가 k - 1 개인 index 값을 구혀면 된다.
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 1;
        int end = k;
        int ans = 0;

        while (true) {
            if (start > end) {
                break;
            }

            int cnt = 0;
            int mid = (start + end) / 2;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(n , mid / i);
            }

            if (cnt >= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        br.close();
        bw.close();
    }
}