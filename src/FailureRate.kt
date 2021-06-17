class Solution36 {
    fun solution(N: Int, stages: IntArray): ArrayList<Int> {

        val result = ArrayList<Int>()
        val sortedStages = stages.sorted()
        val failureRate = HashMap<Int, Double>()

        for (i in 1..N) {
            failureRate.put(
                i,
                (sortedStages.filter { it == i }.size.toDouble() / sortedStages.filter { it >= i }.size.toDouble())
            )
        }

        failureRate.toList().sortedWith(compareBy({ -it.second }, { it.first })).forEach { result.add(it.first) }
        return result
    }
}