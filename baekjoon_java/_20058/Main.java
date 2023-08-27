package baekjoon_java._20058;

/*

20058번 - 마법사 상어와 파이어스톰
https://www.acmicpc.net/problem/20058
분류 : 구현, 그래프 이론, 그래프 탐색, 시뮬레이션, 너비 우선 탐색, 깊이 우선 탐색

2^L씩 n*n 구역으로 배열을 나누며 90도 회전하고 녹는 얼음을 검사한다.

구역 검사는 n*n으로 2^L씩 일정 크기만큼 생기므로 반복문을 사용해서 검사하면 된다.
회전은 90도씩 회전하므로 구역의 크기만큼 임시 배열을 생성하고 규칙에 맞게 임시 배열에 넣은 뒤, 원래 배열에 임시 배열을 넣는다.

녹는 얼음은 얼음이 있을 때 인접한 4방향을 모두 확인하며 녹게 되는 지점을 queue에 넣은 뒤 한 번에 처리한다.

마지막에 BFS로 가장 얼음 덩어리가 큰 곳을 확인한 뒤 출력한다.
전체 얼음의 크기는 처음에 map을 저장하면서 전체 크기를 저장하고, 얼음이 녹을 때마다 1씩 감소시킨다.


*/

import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    StreamTokenizer st = new StreamTokenizer(new InputStreamReader(System.in));
    int[][] map;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int sumIce = 0;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    void solution() throws Exception {
        int N = next();
        map = new int[1 << N][1 << N];
        int Q = next();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                map[y][x] = next();
                sumIce += map[y][x];
            }
        }
        while (Q-- > 0) {
            divide(1 << next());
            melt();
        }
        printAnswer();
    }

    void divide(int len) {
        if (len == 1) return;
        for (int y = 0; y < map.length; y += len) {
            for (int x = 0; x < map.length; x += len) {
                rotate(x, y, len);
            }
        }
    }

    void rotate(int left, int top, int len) {
        int right = left + len - 1;
        int bottom = top + len - 1;
        int[][] temp = new int[len][len];

        for (int y = top; y <= bottom; y++) {
            for (int x = left; x <= right; x++) {
                temp[y - top][x - left] = map[right - x + top][y + left - top];
            }
        }
        for (int y = top; y <= bottom; y++) {
            System.arraycopy(temp[y - top], 0, map[y], left, len);
        }
    }

    void melt() {
        ArrayDeque<Pos> deque = new ArrayDeque<>();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                if (map[y][x] == 0) continue;
                int count = 0;
                for (int d = 0; d < dx.length; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (inArea(nx, ny, map.length) && map[ny][nx] > 0) {
                        count++;
                    }
                }
                if (count < 3) deque.add(new Pos(x, y));
            }
        }
        for (Pos pos : deque) map[pos.y][pos.x]--;
        sumIce -= deque.size();
    }

    void printAnswer() {
        boolean[][] visited = new boolean[map.length][map.length];
        int maxCount = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                if (map[y][x] > 0) {
                    maxCount = Math.max(maxCount, startBFS(visited, new Pos(x, y)));
                }
            }
        }
        System.out.printf(sumIce + "\n" + maxCount);
    }

    int startBFS(boolean[][] visited, Pos startPos) {
        Deque<Pos> deque = new ArrayDeque<>();
        visited[startPos.y][startPos.x] = true;
        deque.add(startPos);
        int count = 1;
        while (!deque.isEmpty()) {
            Pos now = deque.removeFirst();
            for (int d = 0; d < dx.length; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (inArea(nx, ny, map.length) && map[ny][nx] > 0 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    count++;
                    deque.add(new Pos(nx, ny));
                }
            }
        }
        return count;
    }

    boolean inArea(int x, int y, int len) {
        return x >= 0 && x < len && y >= 0 && y < len;
    }

    int next() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }
}

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
2 1
1 2 3 4
5 6 7 8
1 2 3 4
5 6 7 8
1
 */