package baekjoon_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1026 {

    static int N; // 길이 입력받기
    static int[] array = new int[101]; // 배열 크기  101로 초기화(0 ~ 100)

    public static void main(String[] args) throws Exception {

        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 길이 입력받기(1<= N <= 50)

        // A값 입력받기(0 <= A <= 100)
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            pqueue.offer(a);
        }

        // B값 입력받기(0 <= B <= 100)
        st = new StringTokenizer(br.readLine());

        // B값에 해당하는 인덱스의 값++
        for (int i = 0; i < N; i++) {
            int b = Integer.parseInt(st.nextToken());
            array[b]++;
        }

        int sum = 0;
        // 인덱스에 해당하는 값이 1이라면 A의 원소와 곱해서 더한다.
        for (int i = 0; i < 101; i++) {
            if(array[i] == 1) {
                int k = pqueue.poll();
                System.out.println(k +  " " + array[i]);
                sum += i*k;
            }
        }
        System.out.println(sum);
    }
}
