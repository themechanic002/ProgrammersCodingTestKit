import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    Solution2().solution(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500))
}

class Solution2 {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()
        val num = genres.size

        val names = ArrayList<String>()
        val hashMap = HashMap<String, ArrayList<Int>>()
        val hashMap2 = HashMap<String, Int>()

        for(i in 0 until num){
            if(hashMap.containsKey(genres[i])){
                hashMap.getValue(genres[i]).add(plays[i])
                hashMap2.set(genres[i], hashMap2.getValue(genres[i]) + plays[i])
            }
            else{
                hashMap.put(genres[i], arrayListOf(plays[i]))
                hashMap2.put(genres[i], plays[i])
                names.add(genres[i])
            }
        }

        var sorting: ArrayList<String>
        for(i in 0 until hashMap2.size){

        }

        return answer
    }
}
