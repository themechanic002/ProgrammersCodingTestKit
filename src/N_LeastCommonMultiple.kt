fun main() {
    println(Solution72().solution(intArrayOf(2, 6, 8, 14)))
}

class Solution72 {
    fun solution(arr: IntArray): Int {
        val sortedArr = arr.sorted()
        var index = sortedArr.last()
        val biggest = index
        println(index)
        while (true) {
            if (sortedArr.all { index % it == 0 })
                return index
            index += biggest
        }
    }
}