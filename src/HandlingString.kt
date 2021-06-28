class Solution67 {
    fun solution(s: String): Boolean {
        if(s.length == 4 || s.length == 6){
            if(s.all { it >= '0' && it <= '9' })
                return true
        }
        return false
    }
}