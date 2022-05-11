/*

2622번 - 10816
https://www.acmicpc.net/problem/10816

숫자의 개수는 50만이 최대지만, 카드의 값은 -1000만부터 1000만 사이이기 때문에 HashMap을 사용했다.

갖고 있는 카드를 배열에 넣고 정렬한 뒤 이분 탐색을 해서 값을 찾아도 된다.

질문 게시판에 올라온 글을 보고 java 감을 되돌릴 겸 풀었다.
확실히 kotlin이 java보다 쉬운 느낌이다.

 */

package baekjoon_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }
        System.out.println(sb);
    }
}
