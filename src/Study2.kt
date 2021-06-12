fun main() {
    println(Solution15().solution(intArrayOf(1,1,1,1,1), 3))
}

class Solution15 {
    fun solution(numbers: IntArray, target: Int): Int {
        var tree = arrayListOf(0)
        numbers.forEach { value ->
            val child = ArrayList<Int>()
            tree.forEach {
                child.add(it + value)
                child.add(it - value)
            }
            tree = child
        }

        return tree.filter { it == target }.size
    }
}