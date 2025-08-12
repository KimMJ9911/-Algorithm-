import java.io.*;
import java.util.*;

public class Main {
    static int V , E , K , u , v , w;
    static class Node implements Comparable<Node> {
        int E;
        int w;
        public Node(int E , int w) {
            this.E = E;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w , o.w);
        }
    }

    static List<List<Node>> map;
    static boolean[] visited;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());
        map = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            map.add(new ArrayList<>());
        }
        visited = new boolean[V];
        distance = new int[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map.get(u).add(new Node(v , w));
        }

        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (i == K) sb.append(0);
            else if (distance[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(distance[i]);
            sb.append("\n");
        }

        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int k) {
        pq.offer(new Node(k , 0));
        distance[k] = 0;

        while (!pq.isEmpty()) {
            Node next = pq.poll();
            if (distance[next.E] != next.w) continue;
            for (Node val : map.get(next.E)) {
                int next_cost = distance[next.E] + val.w;
                if (next_cost >= distance[val.E]) continue;
                distance[val.E] = next_cost;
                pq.offer(new Node(val.E , next_cost));
            }
        }
    }
}