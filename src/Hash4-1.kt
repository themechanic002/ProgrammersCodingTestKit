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
        val playsPerGenres = HashMap<String, Int>() // <장르, 그 장르의 총 플레이 수 합계>가 들어있는 Map
        val playsList = ArrayList<HashMap<String, Int>>() // 노래들의 순서가 인덱스인 배열. 각 인덱스에 따른 <장르, 플레이수>가 들어있음

        //각 변수에 맞게 값 할당하기
        for (i in 0 until genres.size) {
            playsList.add(hashMapOf(Pair(genres[i], plays[i])))
            if (musicMap.containsKey(genres[i]))
                musicMap.get(genres[i])?.add(plays[i])
            else
                musicMap.put(genres[i], arrayListOf(plays[i]))
        }
        musicMap.keys.forEach { eachKey ->
            playsPerGenres.put(eachKey, musicMap.get(eachKey)!!.sum())
        }
        
        // 가장 플레이 수가 많은 장르부터 answer에다가 최다 플레이 수와 두번째 플레이 수 노래의 인덱스들을 넣어줌.
        val sortedGenres = playsPerGenres.toList().sortedByDescending { it.second }
        sortedGenres.forEach { theGenre ->
            answer.add(
                playsList.indexOf(playsList.find {
                    it.containsValue(
                        musicMap.get(theGenre.first)?.sortedDescending()?.get(0)
                    )
                })
            )
            // 만약 그 장르에 속한 노래가 두 개 이상이라면
            if (musicMap.get(theGenre.first)?.size != 1) {
                // 한 장르에 최다 플레이 수를 가진 노래가 여러 개 있을 수 있으니 이미 answer에 넣은 거는 플레이 수를 -1로 바꿔버림
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