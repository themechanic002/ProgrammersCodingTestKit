fun main() {
    println(Solution13().solution("JEROEN"))
}

class Solution13 {
    fun solution(name: String): Int {
        var answer = 0

        //A가 가장 많이 분포되어 있는 곳 찾기

        var mostAstart: Int = -1
        var mostAend: Int = -1
        var Astart: Int = -1
        var Aend: Int = -1
        for (i in 0..name.lastIndex) {
            if (name[i] == 'A' && Astart == -1) {
                Astart = i
            } else if (name[i] != 'A' && Astart != -1) {
                Aend = i
                //Aend - Astart 는 A의 개수
                if (Aend - Astart > mostAend - mostAstart) {
                    mostAstart = Astart
                    mostAend = Aend
                }
                Astart = -1
                Aend = -1
            }
        }
        if (mostAstart != -1 && mostAend == -1)
            mostAend = name.lastIndex + 1

        //어디로 출발하든 해당 알파벳을 찾기 위한 조작횟수
        for (i in 0..name.lastIndex) {
            //A Z Y X ... 순서
            if (name[i] > 'N') {
                answer += ('Z' - name[i] + 1)
            } else {
                answer += (name[i] - 'A')
            }
        }

        //안 가도 되는 경우
        if (mostAstart == 0 && mostAend == name.lastIndex + 1)
            answer = 0
        //그냥 쭉 가고 끝인 경우들
        else if (mostAstart == -1)
            answer += name.lastIndex
        else if (mostAstart == 1)
            answer += (name.lastIndex - mostAend + 1)
        else if (mostAstart == 0)
            answer += mostAend
        else if (mostAend == name.lastIndex)
            answer += (mostAstart - 1)
        //먼저 가장 맨 끝으로 가고 다시 오른쪽으로 돌아가는 게 유리할 때
        else if (mostAstart - 1 < name.lastIndex - (mostAend - 1))
            if (mostAend - mostAstart < name.lastIndex - mostAend + 1)
                answer += name.lastIndex
            else
                answer = answer + (name.lastIndex - mostAend + 1) + ((mostAstart - 1) * 2)
        //먼저 오른쪽으로 가고 다시 왼쪽으로 돌아가는 게 유리할 때
        else if (mostAstart - 1 >= name.lastIndex - (mostAend - 1))
            if (mostAend - mostAstart < mostAstart - 1)
                answer += name.lastIndex
            else
                answer = answer + ((name.lastIndex - mostAend + 1) * 2) + mostAstart - 1

        return answer
    }
}