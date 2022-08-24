/*

9443번 - Arrangement of Contest
https://www.acmicpc.net/problem/9443

입력받은 문장들의 첫 글자를 알파벳 순으로 몇개 정렬할 수 있는지 확인하는 문제이다.
각 문장의 첫 글자를 check배열에 인덱스로 변환해 그 인덱스의 값을 true로 바꾼다.(A->0, B->1, ... , Z->25)
모두 입력 받으면 가장 먼저 나오는 false의 인덱스가 답이 된다.
단, false가 없으면 indexOf는 -1을 반환하기 때문에 A~Z가 모두 있을 때는 따로 처리해 줘야 한다.

*/

fun main() = System.`in`.bufferedReader().run {
    val check = BooleanArray(26)
    repeat(readLine().toInt()) { check[readLine()[0] - 'A'] = true }
    print(check.indexOf(false).takeIf { it != -1 }?:26)
}

/*
26
A
B
C
D
E
F
G
H
I
J
K
L
M
N
O
P
Q
R
S
T
U
V
W
X
Y
Z

*/