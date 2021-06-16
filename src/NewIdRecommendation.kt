fun main() {
    println(Solution34().solution("b......@"))
}

class Solution34 {
    fun solution(new_id: String): String {
        return rightID(new_id)
    }

    fun rightID(old_id: String): String {
        var id = old_id
        id = old_id.lowercase()
        //id = id.replace("^[a-z0-9]|^-|^.|^_".toRegex(), "")

        var tempArray = arrayListOf('~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '=', '+', '[', ']', '{', '}', ':', '?', ',', '<', '>', '/')

        val tempArray2 = ArrayList<Char>()
        id.forEach {
            if (tempArray.contains(it))
                tempArray2.add(it)
        }
        tempArray2.forEach {
            id = id.replace(it.toString(), "")
        }

        if(id == "")
            return "aaa"


        var count = 0

        var index = 0
        while (index <= id.lastIndex) {
            if (id[index] == '.') {
                ++count
                if (index + 1 <= id.lastIndex && id[index + 1] != '.') {
                    if (count > 1) {
                        id = id.removeRange(index - count + 2, index + 1)
                        count = 0
                        index = -1
                    }
                }
                else if(index == id.lastIndex && count > 1) {
                    id = id.dropLast(count - 1)
                    break
                }
            }
            else
                count = 0
            index++
        }


        if (id.first() == '.') //4단계
            id = id.removeRange(0, 1)
        if(id == "")
            return "aaa"
        if (id.last() == '.') //4단계
            id = id.substring(0, id.lastIndex)
        if (id.isBlank()) //5단계
            id = "a"
        if (id.length > 15) //6단계
            id = id.substring(0, 15)
        if (id.last() == '.') //6단계
            id = id.substring(0, id.lastIndex)
        if (id.length <= 2) //7단계
            while (id.length <= 2)
                id += id.last()

        return id
    }
}