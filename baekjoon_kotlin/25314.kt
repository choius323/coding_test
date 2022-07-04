/*

25314번 - 코딩은 체육과목 입니다
https://www.acmicpc.net/problem/25314

"long "을 입력받은 수를 4로 나눈 몫 만큼 출력하고 "int"를 출력하면 된다.

*/

//fun main(){
//    val sb = StringBuilder()
//    repeat(readln().toInt()/4){ sb.append("long ") }
//    print("${sb}int")
//}

//fun main()=StringBuilder().run{repeat(readln().toInt()/4){append("long ")};print("${this}int")}

//fun main()=print("${StringBuilder().run{repeat(readln().toInt()/4){append("long ")};this}}int")

//fun main(){repeat(readln().toInt()/4){print("long ")};print("int")}

fun main()=print("long ".repeat(readln().toInt())+"int")

/*

*/