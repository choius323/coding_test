/*

2386번 - 도비의 영어 공부
https://www.acmicpc.net/problem/2386

toLowerCase는 deprecated 되고 언어에 따라 맞춰서 사용할 수 있는 lowercase가 생겼다.
count는 인자 없이 사용하면 length와 같은 효과이고 람다 함수를 넣으면 보통 생각하는 count('A')같은 문법으로 사용 가능하다.
숏코딩을 해보고 싶어서 풀었다.

*/

package baekjoon_kotlin._2000

fun main(){while(true)println(readln().lowercase().let{if(it=="#")return else "${it[0]} ${it.count{c->c==it[0]}-1}"})}

/*

*/