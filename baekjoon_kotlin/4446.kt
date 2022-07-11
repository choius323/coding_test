/*

4446번 - ROT13
https://www.acmicpc.net/problem/4446

입력받은 문자가 알파벳이면 바뀌는 글자로 출력하고 아니면 그대로 출력한다.
입력이 여러줄인 점을 주의하자.

*/

// 모움과 자음 리스트로 사이클을 돌며 출력
//fun main() = System.`in`.bufferedReader().run {
//    val vowel = listOf('a', 'i', 'y', 'e', 'o', 'u')
//    val conso =
//        listOf('b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f')
//    val sb = StringBuilder()
//    while (true) {
//        val str = readLine() ?: break
//        for (s in str) {
//            val vi = vowel.indexOf(if (s in 'A'..'Z') s.lowercaseChar() else s)
//            val ci = conso.indexOf(if (s in 'A'..'Z') s.lowercaseChar() else s)
//            val c = if (vi != -1) vowel[(vi + 3) % 6]
//            else if (ci != -1) conso[(conso.indexOf(s) + 10) % 20]
//            else s
//            sb.append(if (s in 'A'..'Z') c.uppercase() else c)
//        }
//        sb.appendLine()
//    }
//    print(sb)
//}

// 바뀔 문자를 텍스트에 넣고 출력. 출처 : https://www.acmicpc.net/source/40717809
private val t=" !\"#\$%&'()*+,-./0123456789:;<=>?@EPLRAGFSOXVCWTIBZDHNYKMJUQ[\\]^_`eplragfsoxvcwtibzdhnykmjuq{|}"
fun main()=System.`in`.bufferedReader().run{print(StringBuilder().apply{readText().forEach{append(if(it=='\n')it else t[it-' '])}})}

// 출처 : https://www.acmicpc.net/source/40717809
//fun main()=System.`in`.bufferedReader().run{System.out.bufferedWriter().run{
//
//    while(true){
//        val a=(readLine()?:return flush()).toCharArray()
//        for(i in a.indices)a[i]=t[a[i]-' ']
//        write(a); newLine()
//    }
//}}

// 해시맵 사용한 숏코딩
//private val word=hashMapOf('a' to 'e','b' to 'p','c' to 'l','d' to 'r','e' to 'a','f' to 'g','g' to 'f','h' to 's','i' to 'o','j' to 'x','k' to 'v','l' to 'c','m' to 'w','n' to 't','o' to 'i','p' to 'b','q' to 'z','r' to 'd','s' to 'h','t' to 'n','u' to 'y','v' to 'k','w' to 'm','x' to 'j','y' to 'u','z' to 'q',)
//fun main()=System.`in`.bufferedReader().run{print(StringBuilder().apply{readText().forEach{append(word[it]?:(word[it.lowercase()[0]]?.uppercase()?:it))}})}

// 해시맵 형식으로 출력
//fun main() {
//    val vowel = listOf('a', 'i', 'y', 'e', 'o', 'u')
//    val conso =
//        listOf('b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f')
//
//    for (i in vowel.indices) {
//        print("\'${vowel[i]}\' to \'${vowel[(i + 3) % vowel.size]}\', ")
//    }
//    println()
//    for (i in conso.indices) {
//        print("\'${conso[i]}\' to \'${conso[(i + 10) % conso.size]}\', ")
//    }
//}

// 대문자 해시맵 출력
//fun main() {
//    val word2 = hashMapOf(
//        'b' to 'p', 'k' to 'v', 'x' to 'j', 'z' to 'q', 'n' to 't', 'h' to 's', 'd' to 'r', 'c' to 'l', 'w' to 'm',
//        'g' to 'f', 'p' to 'b', 'v' to 'k', 'j' to 'x', 'q' to 'z', 't' to 'n', 's' to 'h', 'r' to 'd', 'l' to 'c',
//        'm' to 'w', 'f' to 'g', 'a' to 'e', 'i' to 'o', 'y' to 'u', 'e' to 'a', 'o' to 'i', 'u' to 'y'
//    )
//    val word = hashMapOf<Char, Char>()
//    word2.forEach { (t, u) -> word += t.uppercaseChar() to u.uppercaseChar() }
//    for ((t, u) in word) {
//        print("\'$t\' to \'$u\', ")
//    }
//}

/*
Ita dotf ni dyca nsaw ecc.
Ita dotf ni dyca nsaw ecc.
Ita dotf ni dyca nsaw ecc.

*/