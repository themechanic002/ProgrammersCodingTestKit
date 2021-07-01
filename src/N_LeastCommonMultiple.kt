class Solution72 {
    fun solution(arr: IntArray): Int {
        val sortedArr = arr.sorted()
        var index = sortedArr.last()
        val biggest = index
        while (true) {
            if (sortedArr.all { index % it == 0 })
                return index
            index += biggest
        }
    }
}