class Solution27 {
    val idAndNicknameSet = HashMap<String, String>()

    fun solution(record: Array<String>): ArrayList<String> {
        val answer = ArrayList<String>()
        for (i in record) {
            val job = i.split(" ").get(0)
            val id = i.split(" ").get(1)
            when (job) {
                "Enter" -> {
                    val nickname = i.split(" ").get(2)
                    enter(id, nickname)
                }
                "Change" -> {
                    val nickname = i.split(" ").get(2)
                    change(id, nickname)
                }
            }
        }
        for (i in record) {
            val job = i.split(" ").get(0)
            val id = i.split(" ").get(1)
            when (job) {
                "Enter" -> answer.add(getNickname(id) + "님이 들어왔습니다.")
                "Leave" -> answer.add(getNickname(id) + "님이 나갔습니다.")
            }
        }
        return answer
    }

    fun enter(id: String, nickname: String) {
        idAndNicknameSet.put(id, nickname)
    }

    fun change(id: String, newNickname: String) {
        idAndNicknameSet.set(id, newNickname)
    }

    fun getNickname(id: String): String {
        return idAndNicknameSet.get(id).toString()
    }
}