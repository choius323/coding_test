package baekjoon_kotlin._1000/*

1110번 -
https://www.acmicpc.net/problem/1110



*/
private val o=readln().toInt()
private fun c(n:Int)=n%10*10+(n/10+n%10)%10
private fun m(n:Int,c:Int=0):Int=if(n==o)c+1 else m(c(n),c+1)
fun main()=print(m(c(o)))

/*

*/