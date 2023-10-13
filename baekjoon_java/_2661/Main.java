package baekjoon_java._2661;

/*

2661번 - 좋은수열
https://www.acmicpc.net/problem/2661
분류 : 백트래킹

문자열에 숫자를 추가하며 새로운 문자열을 포함한 수열이 나쁜 수열을 만드는지 확인한다.
숫자는 1,2,3 순서로 추가하며 가장 작은 숫자를 먼저 찾을 수 있게 하고 길이 n의 문자열을 찾으면 답을 출력한다.
수열을 확인할 때는 마지막 숫자부터 1 ~ length/2개씩 수열의 길이를 확인한다.

*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(permutation("", n));
    }

    static String permutation(String str, int n) {
        if (!check(str)) {
            return null;
        }
        if (str.length() == n) {
            return str;
        }
        for (int i = 1; i <= 3; i++) {
            String answer = permutation(str + i, n);
            if (answer != null) {
                return answer;
            }
        }
        return null;
    }

    static boolean check(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) { // 확인할 수열의 길이
            int right = len - 1;
            int left = right - 1 - i;
            boolean isSame = true;
            while (right >= len - i - 1) {
                if (str.charAt(left) != str.charAt(right)) {
                    isSame = false;
                    break;
                }
                left--;
                right--;
            }
            if (isSame) {
                return false;
            }
        }
        return true;
    }
}
