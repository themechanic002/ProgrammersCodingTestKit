fun main() {
    println(Solution10().solution("17"))
}

class Solution10 {
    val result : HashSet<Int>

    init {
        result = HashSet<Int>()
    }

    fun solution(numbers: String): Int {
        var answer = 0
        val numbersList = ArrayList<Int>()
        for(i in 0 until numbers.length){
            numbersList.add(numbers[i].code - 48)
        }
        result.add(numbers.toInt())
        for(i in 1 .. numbers.length){
            swaping(numbersList, 0, i, i)
        }
        for(i in result){
            if(isPrime(i))
                answer++
        }

        return answer
    }

    fun isPrime(num: Int): Boolean{
        for(i in 2 .. (num / 2) + 1){
            if(num % i == 0){
                return false
            }
        }
        return true
    }


    fun swaping(arr: ArrayList<Int>, depth: Int, n:Int, r: Int){
        var arr2: ArrayList<Int>
        if(depth == r){
            var aaa: String = ""
            for(i in 0 until arr.size)
                aaa = aaa + arr[i]
            result.add(aaa.toInt())
            return
        }
        for(i in depth until n){
            arr2 = swap(arr, i, depth)
            swaping(arr2, depth + 1, n, r)
            swap(arr2, i, depth)
        }



    }

    fun swap(arr: ArrayList<Int>, start: Int, end: Int): ArrayList<Int>{
        var temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp
        return arr
    }
}