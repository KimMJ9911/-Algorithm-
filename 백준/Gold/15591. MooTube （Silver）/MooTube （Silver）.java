import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static class Node {
        int end , usado;

        public Node(int end , int usado) {
            this.end = end;
            this.usado = usado;
        }
    }
    static List<Node>[] graph;
    static int[][] distance;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        /**
         * 시작 노드와 연결된 노드들과 그 사이의 거리를 담아야 한다.
         * 하나의 노드에 여러 노드들을 연결할 수 있다.
         */
        graph = new List[N + 1];
        distance = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        //최솟값을 가져야 하기 때문에
        for (int i = 1; i <= N; i++) {
            Arrays.fill(distance[i] , Integer.MAX_VALUE);
        }

        //미리 받을 수 있는 노드들 + 가중치들
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph[p].add(new Node(q , r));
            graph[q].add(new Node(p , r));
        }

        //각 노드들 간에 이어지지 않은 지점은 해당 경로에 붙은 가중치 중 최솟값으로 한다.
        for (int i = 1; i <= N; i++) {
            //시작점을 정하고 = i 그 시작정에서 도달할 수 있는 모든 노드들의 가중치도 계산
            calculate(i);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int j : distance[v]) {
                if (j != Integer.MAX_VALUE && k <= j) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    private static void calculate(int i) {
        //BFS 처럼 계산하면 됨
        //하나의 노드에 의해 갈 수 있는 경로를 하나씩 찾는 것이 아닌 도달할 수 있는 Level 마다 탐색하면 된다.
        //이 경우 BFS 가 맞음
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        queue.offer(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int check = queue.poll();

            for (Node next : graph[check]) {    //  시작값 -> 연결된 다음 노드들 -> 그와 연결된 노드들 -> ....
                if (!visited[next.end]) {
                    distance[i][next.end] = Integer.min(distance[i][check] , next.usado);
                    queue.offer(next.end);
                    visited[next.end] = true;
                }
            }
        }
    }
}