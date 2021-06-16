fun main() {
    println(Solution34().solution("...!@BaT#*..y.abcdefghijklm"))
}

class Solution34 {
    fun solution(new_id: String): String {
        return rightID(new_id)
    }

    fun rightID(old_id: String): String {
        var id = old_id
        id = old_id.lowercase()
        //id = id.replace("^[a-z0-9]|^-|^.|^_".toRegex(), "")
        var tempId1 = id
        var tempArray = arrayListOf('~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '=', '+', '[', ']', '{', '}', ':', '?', ',', '<', '>', '/')
        for (i in 0 until id.length) {
            if(tempArray.contains(id[i]))
                tempId1 = tempId1.removeRange(i, i + 1)
        }
        id = tempId1

        var count = 0

        var tempId = id
        for (i in 0 until id.length) {
            if (id[i] == '.') {
                count++
                if (i + 1 <= id.lastIndex && id[i + 1] != '.') {
                    tempId = tempId.removeRange(i - count + 2, i + 1)
                    count = 0
                }
            }
        }
        id = tempId

        if (id.first() == '.')
            id = id.removeRange(0, 1)
        if (id.isBlank())
            id = "a"
        if (id.length > 15)
            id = id.substring(0, 15)
        if (id.last() == '.')
            id = id.substring(0, id.lastIndex)
        if (id.length <= 2)
            while (id.length >= 3)
                id += id.last()

        return id
    }
}