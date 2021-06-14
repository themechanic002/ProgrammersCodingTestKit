fun main() {
    println(
        Solution21().solution(
            arrayOf("classic", "pop", "classic", "pop", "classic", "classic"),
            intArrayOf(400, 600, 150, 600, 500, 500)
        )
    )
}

class Solution21 {
    fun solution(genres: Array<String>, plays: IntArray): ArrayList<Int> {
        var answer = ArrayList<Int>()

        val musicMap = HashMap<String, ArrayList<Int>>() // 근본이 되는 Map
        val playsPerGenres = HashMap<String, Int>()
        val playsList = ArrayList<HashMap<String, Int>>()

        for (i in 0 until genres.size) {
            if (musicMap.containsKey(genres[i])) {
                musicMap.get(genres[i])?.add(plays[i])
                playsList.add(hashMapOf(Pair(genres[i], plays[i])))
            } else {
                musicMap.put(genres[i], arrayListOf(plays[i]))
                playsList.add(hashMapOf(Pair(genres[i], plays[i])))
            }
        }
        musicMap.keys.forEach { eachKey ->
            playsPerGenres.put(eachKey, musicMap.get(eachKey)!!.sum())
        }

        val sortedGenres = playsPerGenres.toList().sortedByDescending { it.second }
        sortedGenres.forEach { theGenre ->
            answer.add(
                playsList.indexOf(playsList.find {
                    it.containsValue(
                        musicMap.get(theGenre.first)?.sortedDescending()?.get(0)
                    )
                })
            )
            if (musicMap.get(theGenre.first)?.size != 1) {
                playsList.find {
                    it.containsValue(
                        musicMap.get(theGenre.first)?.sortedDescending()?.get(0)
                    )
                }?.set(theGenre.first, -1)

                answer.add(
                    playsList.indexOf(playsList.find {
                        it.containsValue(
                            musicMap.get(theGenre.first)?.sortedDescending()?.get(1)
                        )
                    })
                )
            }
        }

        return answer
    }
}