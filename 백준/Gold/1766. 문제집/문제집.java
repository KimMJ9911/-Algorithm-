import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1~n 개의 문제가 있다. 숫자가 낮은 문제일 수록 쉽다
//위상 정렬을 이용하되 쉬운 문제를 먼저 풀어야 한다.
//14 32 1342 1324
//우선순위 큐를 이용한다?????
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1];
        for (int i = 0; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int val_1 = Integer.parseInt(st.nextToken());
            int val_2 = Integer.parseInt(st.nextToken());
            graph.get(val_1).add(val_2);
            inDegree[val_2]++;
        }

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) pQueue.add(i);
        }

        while (!pQueue.isEmpty()) {
            int val = pQueue.poll();
            ans.add(val);
            for (int next : graph.get(val)) {
                inDegree[next]--;
                if (inDegree[next] == 0) pQueue.add(next);
            }
        }

        for (Integer an : ans) {
            bw.write(an + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}