fun main() {
    println(Solution19().solution(
        arrayOf(
            arrayOf("ICN", "AAA"),
            arrayOf("AAA", "ICN"),
            arrayOf("ICN", "AAA"),
            arrayOf("AAA", "BBB")
        )
    ))
}

class Solution19 {
    fun solution(tickets: Array<Array<String>>): ArrayList<String> {
        var answer = ArrayList<String>()

        val allAirport = ArrayList<String>()
        allAirport.add("ICN")
        tickets.forEach { if(!(allAirport.contains(it[1]))) allAirport.add(it[1]) }

        //티켓 중복 제거
        val ticketsSet = HashSet<Array<String>>()
        for (i in tickets)
            ticketsSet.add(i)

        var tree = ArrayList<String>()
        tree.add("ICN")

        //비대칭인 이진트리로 구현
        for (i in 0 until ticketsSet.size) {
            val child = ArrayList<String>()
            tree.forEach { value ->
                ticketsSet.filter { tic ->
                    value.substring(value.length - 3) == tic.get(0)
                }.forEach { item ->
                    if(item.size == 0)
                        tree.remove(value)
                    else
                        child.add(value + item.get(1))
                }
            }
            tree = child
        }


        allAirport.forEach { eachAirport ->
            for(i in 0 until tree.size)
                if (!(tree[i].contains(eachAirport)))
                    tree.set(i, "")
        }
        tree.filter { it == "" }.forEach { tree.remove(it) }

        //정렬해서 알파벳 순으로 하나만 결과로
        var answertree = tree.sorted().get(0)

        //통째로 되어있는 String을 쪼개서 answer에 넣기
        while(!(answertree.isBlank())) {
            answer.add(answertree.substring(0, 3))
            answertree = answertree.substring(3)
        }
        return answer
    }
}