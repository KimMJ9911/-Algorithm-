import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        //값 저장
        int[] table = new int[n];
        //개수 저장할 배열
        int[] cnt = new int[1_000_001];
        //최종 값을 저장할 배열
        int[] ans = new int[n];
        //위치 저장
        Stack<Integer> idx = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            cnt[table[i]]++;
        }

        idx.push(0);
        for (int i = 1; i < n; i++) {
            while (!idx.isEmpty() && cnt[table[i]] > cnt[table[idx.peek()]]) {
                ans[idx.pop()] = table[i];
            }
            idx.push(i);
        }

        while (!idx.isEmpty()) {
            ans[idx.pop()] = -1;
        }

        for (int i : ans) {
            bw.write(i + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}