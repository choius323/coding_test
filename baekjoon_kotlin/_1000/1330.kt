package baekjoon_kotlin._1000/*

1330번 - 두 수 비교하기
https://www.acmicpc.net/problem/1330

두 수를 정수로 바꾼 뒤 비교하면 된다.
when에서 비교 연산자를 사용하려면 in, a<0이 쓰거나 소괄호 없이 써야 한다.

*/

//fun main()=print(readln().split(" ").map{it.toInt()}.reduce{a,b->a-b}.let{if(it<0)"<" else if(it>0)">" else "=="})
//fun main()=print(readln().split(" ").map{it.toInt()}.let{it[0]-it[1]}.let{if(it<0)"<" else if(it>0)">" else "=="})
fun main(){val(a,b)=readln().split(" ").map{it.toInt()};print(when{a<b->"<";a>b->">";else->"=="})}

/*

*/