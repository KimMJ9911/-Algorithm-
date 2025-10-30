import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine() , " ");
        List<Long> arr = new ArrayList<>();

        //n = (진짜 약수의 최댓값) * (진짜 약수의 최솟값)
        long lcs = 0L;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long val = Long.parseLong(st.nextToken());
            max = Math.max(val , max);
            min = Math.min(val , min);
        }

        lcs = max * min;
        bw.write(String.valueOf(lcs));
        bw.flush();
        br.close();
        bw.close();
    }
}