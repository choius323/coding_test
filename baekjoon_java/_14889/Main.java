/*

14889번 - 스타트와 링크
https://www.acmicpc.net/problem/14889
분류 : 브루트포스 알고리즘, 백트래킹

팀원의 순서가 상관 없기 때문에 각 팀의 팀원을 조합을 통해 구했다.
checked 배열을 만들어 n/2개를 true로 바꿨을 때 true인 팀과 false인 팀의 점수를 계산했다.

*/

package baekjoon_java._14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] checked;
    static int[][] scores;
    static int n;
    static int answer = 999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scores = new int[n][n];
        checked = new boolean[n];
        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                scores[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        for (int y = 0; y < n; y++) {
            for (int x = y + 1; x < n; x++) {
                scores[y][x] += scores[x][y];
            }
        }
        comb(0, 0);
        System.out.print(answer);
    }

    static void comb(int count, int index) {
        if (count == n / 2) {
            getScoreDiff();
            return;
        }
        if (index == n) return;
        for (int i = index; i < n; i++) {
            checked[i] = true;
            comb(count + 1, i + 1);
            checked[i] = false;
        }
    }

    static void getScoreDiff() {
        int scoreA = 0;
        int scoreB = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                if (checked[a] == checked[b]) {
                    if (checked[a]) {
                        scoreA += scores[a][b];
                    } else {
                        scoreB += scores[a][b];
                    }
                }
            }
        }
        answer = Math.min(answer, Math.abs(scoreA - scoreB));
    }
}
