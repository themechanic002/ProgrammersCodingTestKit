fun main() {
    Solution18().solution(
        arrayOf(
            arrayOf("ICN", "AAA"),
            arrayOf("ICN", "AAA"),
            arrayOf("ICN", "AAA"),
            arrayOf("ICN", "AAA"),
            arrayOf("AAA", "BBB"),
            arrayOf("AAA", "CCC"),
            arrayOf("CCC", "AAA"),
            arrayOf("BBB", "DDD")
        )
    )
}

class Solution18 {
    fun solution(tickets: Array<Array<String>>): ArrayList<String> {
        var answer = ArrayList<String>()

        //티켓 중복 제거
        val ticketsSet = HashSet<ArrayList<String>>()
        for (i in tickets)
            ticketsSet.add(arrayListOf(i[0], i[1]))

        var tree = arrayListOf<String>()
        tree.add("ICN")

        //비대칭인 이진트리로 구현
        for (i in 0 until ticketsSet.size) {
            val child = ArrayList<String>()
            tree.forEach { value ->
                ticketsSet.filter { tic ->
                    value.substring(value.length - 3) == tic.get(0)
                }.forEach { item ->
                    if (!(value.contains((item.get(0) + item.get(1)))))
                        child.add(value + item.get(1))
                }
            }
            tree = child
        }
        //정렬해서 알파벳 순으로 하나만 결과로
        tree.sort()

        //통째로 되어있는 String을 쪼개서 answer에 넣기
        for (i in 1..(tree[0].length / 3)) {
            answer.add(tree[0].substring(0, 3))
            tree[0] = tree[0].substring(3)
        }
        return answer
    }
}