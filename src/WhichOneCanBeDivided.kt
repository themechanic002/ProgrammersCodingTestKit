class Solution41 {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        val answer: MutableList<Int> = arr.filter { it % divisor == 0 }.sorted().toMutableList()
        if (answer.isEmpty()) answer.add(-1)
        return answer.toIntArray()
    }
}