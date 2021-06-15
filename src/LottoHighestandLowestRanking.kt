class Solution25 {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val definite = lottos.filter { win_nums.contains(it) }.size
        return intArrayOf(
            when (val lowest = 7 - (definite + lottos.filter { it == 0 }.size)) {
                7 -> 6
                else -> lowest
            },
            when (val highest = 7 - (definite)) {
                7 -> 6
                else -> highest
            }
        )
    }
}