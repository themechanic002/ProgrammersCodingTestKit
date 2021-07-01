class Solution72 {
    fun solution(arr: IntArray): Int {
        var sortedArr = arr.sortedDescending()
        var index = sortedArr.first()
        while (true){
            if(sortedArr.all { it % index == 0 }){
                return index
            }
            else
                index += index
        }
    }
}