class Solution72 {
    fun solution(arr: IntArray): Int {
        var sortedArr = arr.sortedDescending()
        var index = sortedArr.first()
        while (true){
            if(sortedArr.all { index % it == 0 })
                return index
            index += index
        }
    }
}