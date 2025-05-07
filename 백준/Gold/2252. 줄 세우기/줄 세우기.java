import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1];

        for (int i = 0; i <= n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        //각 숫자에 대한 깊이 지정
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int val_1 = Integer.parseInt(st.nextToken());
            int val_2 = Integer.parseInt(st.nextToken());
            graph.get(val_1).add(val_2);
            inDegree[val_2]++;
        }

        //깊이가 0인 지점 먼저 넣기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            //초기 값을 하나 지정하고 그 수와 연결된 수들을 진입 차수를 이용해 정렬
            int val = queue.poll();
            ans.add(val);
            for (int next : graph.get(val)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.add(next);
            }
        }

        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
}