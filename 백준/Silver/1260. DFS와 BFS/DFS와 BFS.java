import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> map;
    static Queue<Integer> queue;
    static int N , M , R , cnt_B = 1 , cnt_D = 1;
    static boolean[] visited_BFS , visited_DFS;
    static int[] vertex_BFS , vertex_DFS;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        //정점 갯수
        N = Integer.parseInt(st.nextToken());
        //간선 갯수
        M = Integer.parseInt(st.nextToken());
        //첫 정점
        R = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        visited_BFS = new boolean[N + 1];
        visited_DFS = new boolean[N + 1];
        vertex_BFS = new int[N + 1];
        vertex_DFS = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.get(start).add(end);
            map.get(end).add(start);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(map.get(i));
        }

        DFS(R , 1);
        sb.append("\n");
        BFS(R);

        sb.append("\n");

        bw.write(sb + "");
        bw.flush();
        br.close();
        bw.close();
    }
    private static void DFS(int r , int depth) {
        if (depth == N)  {
            sb.append(r);
            return;
        }
        visited_DFS[r] = true;
        sb.append(r).append(" ");
        for (int val : map.get(r)) {
            if (!visited_DFS[val]) {
                visited_DFS[val] = true;
                DFS(val , depth + 1);
            }
        }
    }

    private static void BFS(int r) {
        queue = new LinkedList<>();
        queue.add(r);

        visited_BFS[r] = true;
        sb.append(r).append(" ");

        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (int val : map.get(next)) {
                if (!visited_BFS[val]) {
                    queue.offer(val);
                    sb.append(val).append(" ");
                    visited_BFS[val] = true;
                }
            }
        }
    }
}