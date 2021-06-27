class Solution66 {
    fun solution(n: Int): Int {
        val divisor = ArrayList<Int>()
        for(i in 1 .. n){
            if(n % i == 0)
                divisor.add(i)
        }
        return divisor.sum()
    }
}