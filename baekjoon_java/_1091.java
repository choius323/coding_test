package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1091 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine()); // 카드의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] P = new int[N]; // 0, 1, 2. 어떤 플레이어에게 가야 하는지 적혀 있음.
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] S = new int[N]; // 0 ~ N - 1. 어떤 위치로 이동 하는지
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] cardArray = Arrays.copyOf(P, P.length);

        checkCard(N, cardArray, sb, 0);

        for (int i = 1; sb.length() < 1; i++) {
            cardArray = moveCard(N, S, cardArray);
//            System.out.println("i : " + i);

            checkCard(N, cardArray, sb, i);
            if (Arrays.equals(cardArray, P)) {
                sb.append(-1);
            }
        }

        System.out.println(sb);
    }

    public static int[] moveCard(int N, int[] S, int[] cardArrays) {
        int[] S2 = new int[N];

        for (int i = 0; i < N; i++) {
            S2[S[i]] = cardArrays[i];
        }

        return S2;
    }

    public static void checkCard(int N, int[] cardArray, StringBuilder sb, int count) {
        for (int j = 0; j < N; j++) {
            if (j % 3 != cardArray[j]) {
                break;
            } else if (j == N - 1) {
                sb.append(count);
            }
        }
    }
}
