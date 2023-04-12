fun main(){

}

class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playerRankMap = hashMapOf<String,Int>()
        val rankPlayerMap = hashMapOf<Int,String>()
        players.forEachIndexed { index, s ->
            playerRankMap[s] = index
            rankPlayerMap[index] = s
        }

        callings.forEach { name ->
            val callRank = playerRankMap[name]!!
            val otherPlayer = rankPlayerMap[callRank-1]!!
            rankPlayerMap[callRank-1] = name
            rankPlayerMap[callRank] = otherPlayer
            playerRankMap[name] = callRank - 1
            playerRankMap[otherPlayer] = callRank
        }

        return rankPlayerMap.toList().let {
            it.sortedBy { it.first }.map { pair -> pair.second }.toTypedArray()
        }
    }

    fun recursionRace(players: MutableList<String>, nextCalling: MutableList<String>): MutableList<String> {
        if (nextCalling.isEmpty()) return players

        val targetName = nextCalling.removeFirst()
        val targetIndex = players.indexOf(targetName)

        players.removeAt(targetIndex)
        players.add(targetIndex-1,targetName)

        return recursionRace(players, nextCalling)
    }
}