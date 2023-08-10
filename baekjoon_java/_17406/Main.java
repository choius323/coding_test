package baekjoon_java._17406;

/*

17406번 - 배열 돌리기 4
https://www.acmicpc.net/problem/17406
분류 : 구현, 브루트포스 알고리즘, 백트래킹

모든 명령어를 저장하고 모든 명령어 순열을 만들며 최솟값을 찾는다.
사용한 명령어는 visit에 저장하고 비트 연산자를 사용해 비교하며, 모든 명령어를 다 사용했을 때만 최솟값을 갱신했다.

*/

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static Command[] commands;
    static int maxVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] array = new int[n][m];
        int k = sc.nextInt();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                array[y][x] = sc.nextInt();
            }
        }
        commands = new Command[k];
        maxVisited = (1 << k) - 1;
        for (int i = 0; i < k; i++) {
            commands[i] = new Command(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
        }
        perm(array, 0);
        System.out.println(min);
    }

    static void perm(int[][] array, int visited) {
        if (visited == maxVisited) {
            min = Math.min(min, getArrayValue(array));
        }
        int[][] copy = new int[array.length][array[0].length];
        for (int i = 0; i < commands.length; i++) {
            if ((visited & (1 << i)) != 0) continue;
            deepCopy(array, copy);
            rotate(commands[i], copy);
            perm(copy, visited | (1 << i));
        }
    }

    static void deepCopy(int[][] array, int[][] copy) {
        for (int i = 0; i < copy.length; i++) {
            copy[i] = Arrays.copyOf(array[i], array[i].length);
        }
    }

    static void rotate(Command command, int[][] array) {
        int r = command.r;
        int c = command.c;
        int s = command.s;
        for (int d = 1; d <= s; d++) {
            int temp = array[r - d][c - d];
            //왼쪽열
            for (int y = r - d; y < r + d; y++)
                array[y][c - d] = array[y + 1][c - d];
            //아래행
            for (int x = c - d; x < c + d; x++)
                array[r + d][x] = array[r + d][x + 1];
            //오른쪽열
            for (int y = r + d; y > r - d; y--)
                array[y][c + d] = array[y - 1][c + d];
            //위쪽행
            for (int x = c + d; x > c - d; x--)
                array[r - d][x] = array[r - d][x - 1];
            array[r - d][c - d + 1] = temp;
        }
    }

    static int getArrayValue(int[][] array) {
        return Arrays.stream(array).mapToInt(ints -> Arrays.stream(ints).sum()).min().orElse(Integer.MAX_VALUE);
    }
}

class Command {
    int r, c, s;

    public Command(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}

/*
5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
4 2 1
3 4 2

12
 */