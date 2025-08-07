import java.io.*;
import java.util.*;

public class Main {
    static int N , M , R;
    static Queue<Integer> queue;
    static List<List<Integer>> map;
    static boolean[] visited;
    static int[] distance;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        //정점 생성
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            //무방향 그래프 작성
            map.get(start).add(end);
            map.get(end).add(start);
        }

        //정점을 크기 순서대로 정렬
        for (int i = 0; i <= N; i++) {
            Collections.sort(map.get(i));
        }

        BFS(R);

        for (int i = 1; i <= N; i++) {
            bw.write(distance[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void BFS(int R) {
        queue = new LinkedList<>();
        queue.offer(R);
        visited[R] = true;

        distance[R] = cnt++;
        while (!queue.isEmpty()) {
            int next = queue.poll();

            for (int post : map.get(next)) {
                if (!visited[post]) {
                    visited[post] = true;
                    distance[post] = cnt++;
                    queue.offer(post);
                }
            }
        }
    }
}