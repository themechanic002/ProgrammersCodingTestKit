class Solution47 {
    fun solution(s: String): ArrayList<Int> {
        val tupleArray = s.substring(2, s.lastIndex - 1).split("},{")
        val tupleSet = HashSet<List<String>>()
        for (i in tupleArray)
            tupleSet.add(i.split(","))

        var answer = ArrayList<Int>()
        tupleSet.toList().sortedBy { it.size }.forEach { bigRange ->
            for (i in 0 until bigRange.size)
                if (!answer.contains(bigRange[i].toInt()))
                    answer.add(bigRange[i].toInt())
        }
        return answer
    }
}