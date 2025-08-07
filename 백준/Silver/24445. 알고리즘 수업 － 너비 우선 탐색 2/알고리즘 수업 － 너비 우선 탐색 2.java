import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> map;
    static int[] distance;
    static boolean[] visited;
    static Queue<Integer> queue;
    static int N , M , R , cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

       N =  Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       R = Integer.parseInt(st.nextToken());

       distance = new int[N + 1];
       visited = new boolean[N + 1];
       map = new ArrayList<>();

       //map , distance , visited 모두 1 ~ N 을 저장함
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

        for (int i = 1; i <= N; i++) {
            Collections.sort(map.get(i) , Collections.reverseOrder());
        }

        BFS(R);

        for (int i = 1; i <= N; i++) {
            bw.write(distance[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(int r) {
        queue = new LinkedList<>();
        queue.offer(r);
        visited[r] = true;

        distance[r] = cnt++;
        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (int val : map.get(next)) {
                if (!visited[val]) {
                    visited[val] = true;
                    distance[val] = cnt++;
                    queue.offer(val);
                }
            }
        }
    }
}