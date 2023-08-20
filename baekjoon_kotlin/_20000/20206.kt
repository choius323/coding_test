/*

20206번 - 푸앙이가 길을 건너간 이유
https://www.acmicpc.net/problem/20206

선의 방정식은 ax+by+c=0 이고 y=-(ax+c)/b로 나타낼 수 있다.
이 식에 x1, x2를 대입한 값이 y1과 y2의 범위 밖에 있으면 안전하다.
그리고 x1과 x2를 대입한 값은 [x1, x2] 구간의 최소값, 최대값 중 하나이다.
(최소값)>=y2||(최대값)<=y1 일 때 Lucky를 출력하면 된다.
단, b로 나누면 부동 소수점 문제가 있으므로 양변에 b를 곱하고 부등호의 방향이 바뀌게 된다.
따라서 y1*b와 y2*b가 b의 값에 따라 대소 관계가 바뀔 수 있다.

y1<-(a*x+c)/b<y2 에서 위험 구역을 지나가게 되는데
b>0이면, b*y1<-a*x-c<b*y2
b<0이면, b*y1>-a*x-c>b*y2 이다.
따라서 >=max(b*y1,b*y2) | <=min(b*y1,b*y2)이면 안전하다.
선의 최대 값은 max(-a*x1-c,-a*x2-c) -> -c(max(-a*x1,-a*x2) -> -c -min(a*x1,a*x2)가 되며 최소값도 마찬가지이다.

추가로 b=0일 때, ax+c=0이 되고 x=-a/c가 된다.
x1<-c/a<x2일 때 위험 지역을 지나게 되는데
a>0이면, a*x1<-c<a*x2 -> 0<-a*x1-c & -a*x2-c<0
a<0이면, a*x1>-c>a*x2 -> 0>-a*x1-c & -a*x2-c>0 이다.
여기서 위에 나왔던 식에 대입하면 b*y1과 b*y2는 항상 0이므로 b가 0이어도 같은 식을 사용하게 된다.

참고 링크:
https://ddoongi.tistory.com/245

*/

package baekjoon_kotlin._20000

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    fun i(): Int {
        nextToken()
        return nval.toInt()
    }

    val a = i()
    val b = i()
    val c = i()
    val x1 = i() * a
    val x2 = i() * a
    val y1 = i() * b
    val y2 = i() * b

    print(if (-c - maxOf(x1, x2) >= maxOf(y1, y2) || -c - minOf(x1, x2) <= minOf(y1, y2)) "Lucky" else "Poor")
}

/*

*/