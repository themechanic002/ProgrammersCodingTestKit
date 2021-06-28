class Solution67 {
    fun solution(s: String): Boolean = (s.length == 4||s.length == 6) && (s.all { it in '0'..'9' })
    /*{
        if(s.length == 4 || s.length == 6)
            if(s.all { it >= '0' && it <= '9' })
                return true
        return false
    }*/
}