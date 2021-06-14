fun main() {
    println(
        Solution20().solution(
            arrayOf("classic", "pop", "classic", "classic", "pop"),
            intArrayOf(500, 600, 150, 800, 2500)
        )
    )
}

class Solution20 {
    fun solution(genres: Array<String>, plays: IntArray): ArrayList<Int?> {
        var answer = ArrayList<Int?>()

        val musicMap = HashMap<String, ArrayList<Int>>() // 근본이 되는 Map
        val playsPerGenres = HashMap<String, Int>() // <장르, 그 장르의 총 플레이 수 합계>가 들어있는 Map
        val genresSet = HashSet<String>() // 장르만 모아놓은 집합
        val playsList = ArrayList<Int>() // 노래들의 순서가 인덱스인 배열. 각 인덱스에 따른 플레이 수가 담겨있음

        //값 할당하기
        for (i in 0 until genres.size) {
            if (!musicMap.containsKey(genres[i])) {
                musicMap.put(genres[i], arrayListOf(plays[i]))
                genresSet.add(genres[i])
                playsList.add(plays[i])
            } else {
                musicMap.get(genres[i])?.add(plays[i])
                playsList.add(plays[i])
            }
        }
        musicMap.keys.forEach { eachKey ->
            playsPerGenres.put(eachKey, musicMap.get(eachKey)!!.sum())
        }


        val firstGenre: String // 총 플레이 수가 가장 많은 장르
        var secondGenre: String = "" // 총 플레이 수가 두번째로 많은 장르

        // 가장 플레이 수가 많은 장르와 두번째로 많은 장르 추려내기
        val sortedGenre = playsPerGenres.toList().sortedByDescending { it.second }
        firstGenre = sortedGenre[0].first
        if (genresSet.size >= 2)
            secondGenre = sortedGenre[1].first


        val firstGenreSortedPlay = musicMap.get(firstGenre)!!.sortedDescending()
        val secondGenreSortedPlay = musicMap.get(secondGenre)?.sortedDescending()

        // answer에다가 playsList 배열을 이용해 많이 들은 노래의 인덱스값만을 넣어주기
        when (firstGenreSortedPlay.size) {
            1 -> answer.add(playsList.indexOf(playsList.find { it == firstGenreSortedPlay.get(0) }))
            else -> {
                answer.add(playsList.indexOf(playsList.find { it == firstGenreSortedPlay.get(0) }))
                answer.add(playsList.indexOf(playsList.find { it == firstGenreSortedPlay.get(1) }))
            }
        }
        if (!secondGenreSortedPlay.isNullOrEmpty())
            when (secondGenreSortedPlay.size) {
                1 -> answer.add(playsList.indexOf(playsList.find { it == secondGenreSortedPlay.get(0) }))
                else -> {
                    answer.add(playsList.indexOf(playsList.find { it == secondGenreSortedPlay.get(0) }))
                    answer.add(playsList.indexOf(playsList.find { it == secondGenreSortedPlay.get(1) }))
                }
            }

        return answer
    }
}