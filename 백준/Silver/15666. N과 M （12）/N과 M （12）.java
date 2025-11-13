import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n , m;
    static boolean[] visited;
    static int[] num , ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<Integer> arr = new HashSet<>();
        st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        num = arr.stream().mapToInt(Integer::intValue).toArray();
        visited = new boolean[arr.size() + 1];
        ans = new int[m];
        Arrays.sort(num);

        BFS(0 , 0);

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(int depth , int k) {
        if (depth == m) {
            for (int an : ans) {
                sb.append(an).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = k; i < num.length; i++) {
            ans[depth] = num[i];
            BFS(depth + 1 , i);
            ans[depth] = 0;
        }
    }
}