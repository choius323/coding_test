package baekjoon_kotlin._13000

/*

13335번 - 트럭
https://www.acmicpc.net/problem/13335

매 시간마다 트럭을 이동시키며 트럭이 다 이동하는 시간을 확인했다.
다리의 길이 만큼의 크기를 갖는 배열을 만들고, 그 배열에는 어떤 무게의 트럭이 있는지 저장하고 트럭이 없으면 null을 넣었다.
배열의 인덱스는 증가하는 방식으로 배열을 순회하고 시간에 따라 1 증가한다.
트럭의 길이는 1이고 겹치는 일이 없으며 인덱스가 돌아왔을 때가 다리를 나가는 시기와 같다.

다리 위에 완전히 올라가지 않은 트럭은 무게를 포함하지 않기 때문에 시간이 바뀌는 것과 동시에 무게에서 제외시켰다.

*/

fun main() = java.io.StreamTokenizer(System.`in`.bufferedReader()).run {
    val r = { nextToken();nval.toInt() }
    val n = r()
    val w = r()
    val l = r()
    val bridge = Array<Int?>(w) { null }
    var index = 0
    var next = r()
    var totalWeight = 0
    var count = 0
    var time = 1

    while (count < n) {
        //다리에 진입할 수 있는지 확인
        if (totalWeight + next <= l) {
            totalWeight += next
            bridge[index] = next
            next = runCatching { r() }.getOrNull() ?: l
        }

        //시간 지남
        index = (++index) % w
        time++

        //다리에서 트럭이 빠져나감
        if (bridge[index] != null) {
            totalWeight -= bridge[index]!!
            bridge[index] = null
            count++
        }
    }
    print(time)
}

/*

*/