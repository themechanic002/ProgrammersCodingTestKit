fun main() {
    println(Solution32().solution(intArrayOf(-1,0,1, 8, 2), intArrayOf(1,0,-1, 4, -4)))
}
class Solution32 {
    fun solution(a: IntArray, b: IntArray): Int {
        val answer = ArrayList<Int>()
        for (i in 0 until a.size)
            answer.add(a[i] * b[i])
        return answer.sum()
    }
}