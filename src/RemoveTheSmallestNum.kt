class Solution62 {
    fun solution(arr: IntArray): IntArray {
        val arr2 = arr.copyOf().sorted().toList()
        val smallest = arr2.first()
        val answer = ArrayList<Int>()
        arr.forEach {
            if(it != smallest)
                answer.add(it)
        }
        if(arr2.isEmpty())
            return intArrayOf(-1)
        else
            return answer.toIntArray()
    }
}