import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        /**
         * 위상 정렬 알고리즘 공부하기
         * 이건 graph 자료 구조형이랑 가중치(inDegree) 에 대한 개념만 알고 있으면 된다.
         * 뒤에 오는 수는 그만큼의 가중치를 더해야 하므로 한 줄 씩 받아가면서 가중치를 더해주면 된다.
         * 나중에 줄세울때 가중치 만큼 뒤로 보내주면 되는 거기 때문에 가중치만 신경쓰면서 하자.
         * 가중치가 먼저 0이 되는 node 를 먼저 출력해준다.
         */

        st = new StringTokenizer(br.readLine() , " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        //갯수만큼 줄을 세운 결과를 받으면서 가중치까지 기록
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            inDegree[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            int next = queue.poll();
            ans.add(next);

            for (int val : graph.get(next)) {
                inDegree[val]--;
                if (inDegree[val] == 0) queue.offer(val);
            }
        }

        for (Integer a : ans) {
            bw.write(a + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}