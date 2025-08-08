import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> map;
    static Queue<Integer> queue;
    static int N , M , R;
    static boolean[] visited;
    static boolean[] infected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //정점 갯수
        N = Integer.parseInt(br.readLine());
        //간선 갯수
        M = Integer.parseInt(br.readLine());

        map = new ArrayList<>();
        visited = new boolean[N + 1];
        infected = new boolean[N + 1];

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

        BFS(1);

        int ans = -1;
        for (int i = 1; i <= N; i++) {
            if (infected[i]) ans++;
        }

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(int r) {
        queue = new LinkedList<>();
        queue.add(r);

        visited[r] = true;
        infected[r] = true;

        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (int val : map.get(next)) {
                if (!visited[val]) {
                    queue.offer(val);
                    infected[val] = true;
                    visited[val] = true;
                }
            }
        }
    }
}