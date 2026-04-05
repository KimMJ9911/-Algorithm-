import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean game_ends;
    static int n , m , result = -1;
    static String[][] map;
    static int[] dx = {-1 , 1 , 0 , 0} , dy = {0 , 0 , -1 , 1};

    static class Pair {
        int rx; int ry;
        int bx; int by;

        public Pair(int rx , int ry , int bx , int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n + 1][m + 1];  // 전체 보드의 갯수 + 1을 해야 bfs 이동에 outOfBound 에러가 발생하지 않음

        int srx = 0 , sry = 0 , sbx = 0 , sby = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = String.valueOf(line.charAt(j));

                if (line.charAt(j) == 'R') {srx = i; sry = j;}
                if (line.charAt(j) == 'B') {sbx = i; sby = j;}
            }
        }

        bfs(new Pair(srx , sry , sbx , sby));

        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(Pair curr) {
        int cnt = 0;  // 총 이동한 횟수
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(curr);

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;  // 마지막에는 움직일 수 없어도 + 1 이기 때문에 예외 처리가 필요 없다. 이러면 10개 이상이면 -1 출력도 가능하다.
            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Pair next = move(j , curr);

                    if (next == null) continue;

                    if (game_ends) {
                        result = cnt;
                        return;
                    }

                    queue.offer(next);  // bfs 로직대로 다음 움직임 저장
                }
            }
            if (cnt >= 10) break;
        }
    }

    static Pair move(int dir , Pair curr) {
        int flagR = 0 , flagB = 0;  // 현재 공 상태를 나타내는 지표
        boolean[] endPoint = {false , false};
        Pair next = new Pair(curr.rx , curr.ry , curr.bx , curr.by);

        while (true) {
            if (endPoint[0] && endPoint[1]) {
                if (flagR == 1 && flagB == 0) {
                    game_ends = true;
                    break;
                }
                else if (flagR == 1 && flagB == 1) return null;
                else if (flagR == 0 && flagB == 1) return null;
                else break;
            }

            // 공이 벽에 막힐 때 까지
            if (!endPoint[0] && !map[next.rx + dx[dir]][next.ry + dy[dir]].equals("#")) {
                next.rx += dx[dir];
                next.ry += dy[dir];
            } else endPoint[0] = true;

            if (!endPoint[1] && !map[next.bx + dx[dir]][next.by + dy[dir]].equals("#")) {
                next.bx += dx[dir];
                next.by += dy[dir];
            } else endPoint[1] = true;

            // 공이 종료 자점에 도착한 경우
            if (!endPoint[0] &&  map[next.rx][next.ry].equals("O")) {
                flagR = 1;
                endPoint[0] = true;
            }

            if (!endPoint[1] && map[next.bx][next.by].equals("O")) {
                flagB = 1;
                endPoint[1] = true;
            }

            // 두 공이 만나는 경우
            if (!endPoint[0] && next.rx == next.bx && next.ry == next.by) {
                next.rx -= dx[dir];
                next.ry -= dy[dir];
                endPoint[0] = true;
            }

            if (!endPoint[1] && next.rx == next.bx && next.ry == next.by) {
                next.bx -= dx[dir];
                next.by -= dy[dir];
                endPoint[1] = true;
            }
        }
        return next;
    }
}