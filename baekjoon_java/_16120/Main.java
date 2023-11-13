package baekjoon_java._16120;

/*

16120번 - PPAP
https://www.acmicpc.net/problem/16120
분류 : 자료 구조, 문자열, 스택

PPAP를 모두 P로 바꾸는 과정을 거쳐서 마지막에 P만 남는지 확인하면 된다.
PPAP를 P로 바꾸려면 P가 나왔을 때 직전 문자가 A이고 그 전에 P가 2개 이상 나왔는지 확인하면 된다.
만약 A가 나왔을 때 직전에 A가 나왔거나, 이전에 나온 P의 개수가 2개보다 작으면 PPAP가 되지 않는다.

*/

public class Main {
    public static void main(String[] args) {
        int countP = 0;
        boolean findA = false;
        String str = new java.util.Scanner(System.in).next();
        String answer = "PPAP";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'P') {
                if (findA) {
                    countP--;
                    findA = false;
                } else {
                    countP++;
                }
            } else {
                if (countP < 2 || findA) {
                    answer = "NP";
                    break;
                } else {
                    findA = true;
                }
            }
        }
        if (countP != 1) {
            answer = "NP";
        }
        System.out.print(answer);
    }
}
