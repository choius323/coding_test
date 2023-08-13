package baekjoon_kotlin._6000/*

6324번 - URLs
https://www.acmicpc.net/problem/6324

5가지의 경우를 확인하고 분기를 나눠서 출력하면 된다.
protocol과 host는 고정이고 그 뒤에 오는 특수 문자가 :/, /:, :, /와 아무것도 없는 경우 총 5개이다.
port와 path 하나만 있거나 없는 경우는 평범하게 출력하면 된다.
하지만 둘 다 있을 때는 콜론이 슬래시 뒤에 있는 경우 path로 들어간다.
따라서 :/는 port-path이고 /:는 path만 있고 port는 없는 것이 된다.
실제로 url에 이런 경우가 있는 지 모르겠다.

indexOf의 파라미터는 String, Char 둘 다 되고 반환값은 제일 왼쪽에 일치하는 인덱스가 되고 없으면 -1이다.

당연히 정규식으로 하면 비교도 되지 않을 정도로 코드가 간단해진다.

*/

fun main() = System.`in`.bufferedReader().run {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        sb.append("URL #${it + 1}\n")
        var url = readLine()
        val protocol = if (url[0] == 'h') "http" else if (url[0] == 'f') "ftp" else "gopher"
        url = url.slice(url.indexOf("//") + 2 until url.length)
        val host: String
        val port: String
        val path: String
        val colon = url.indexOf(':')
        val slash = url.indexOf('/')
        if (colon == -1 && slash == -1) {
            host = url
            port = "<default>"
            path = "<default>"
        } else if (colon != -1 && slash != -1) {
            host = url.slice(0 until minOf(slash, colon))
            port = if (colon < slash) url.slice(colon + 1 until slash) else "<default>"
            path = url.slice(slash + 1 until url.length)
        } else if (slash == -1) {
            host = url.slice(0 until colon)
            port = url.slice(colon + 1 until url.length)
            path = "<default>"
        } else {
            host = url.slice(0 until slash)
            port = "<default>"
            path = url.slice(slash + 1 until url.length)
        }
        sb.append("Protocol = $protocol\n")
            .append("Host     = $host\n")
            .append("Port     = $port\n")
            .append("Path     = $path\n")
            .append("\n")
    }
    print(sb)
}

/*
5
ftp://acm.baylor.edu:1234/pub/staff/mr-p
http://www.inf12o_.rm-atik.uni-ulm.de/acm
http://www.inf12o_.rm-atik.uni-ulm.de/acm:1235
gopher://veryold.edu
gopher://alkn.faoiwem:133

*/