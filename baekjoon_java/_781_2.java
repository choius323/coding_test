package baekjoon_java;

import java.util.Scanner;

public class _781_2 {
    public static void main(String[] args) {
        int a = new Scanner(System.in).nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= a; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        System.out.println(sb);
    }
}
