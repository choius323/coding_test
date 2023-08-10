/*

10989번 - 수 정렬하기 3
https://www.acmicpc.net/problem/10989
분류 : 정렬

모든 수를 배열에 저장하고 정렬한 뒤 출력했다.
값이 10000이하이기 때문에 1~10000이 나온 횟수를 저장하는 배열을 만들고, 각 횟수만큼 인덱스를 출력하는 것이 더 빠르다.

*/

package baekjoon_java;

import java.io.*;
import java.util.Arrays;

public class _10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        for (int num : Arrays.stream(nums).sorted().toArray()) {
            bw.write(num + "\n");
        }
        bw.flush();
    }
}
