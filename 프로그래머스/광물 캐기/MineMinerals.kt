class Solution {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0
        val maxSize
                = if ((picks[0]+picks[1]+picks[2])*5 < minerals.size) {(picks[0]+picks[1]+picks[2])*5}
        else {minerals.size}
        val mineralSetList = initMineralSet(picks, minerals, maxSize)
        val mineScoreMap = listOf<Map<String,Int>>(
            mapOf(Pair("diamond",1),Pair("iron",1),Pair("stone",1)),
            mapOf(Pair("diamond",5),Pair("iron",1),Pair("stone",1)),
            mapOf(Pair("diamond",25),Pair("iron",5),Pair("stone",1))
        )
        val pickaxeList = initPickaxeList(picks)

        mineralSetList.forEach{ set ->
            val pickaxe = pickaxeList.removeFirst()
            set.mineralsList.forEach{ name ->
                answer += mineScoreMap[pickaxe][name]!!
            }
        }

        return answer
    }

    fun initPickaxeList(picks: IntArray): MutableList<Int>{
        val resultList = mutableListOf<Int>()
        for (index in picks.indices){
            for (i in 1..picks[index]){
                resultList.add(index)
            }
        }
        return resultList
    }

    fun initMineralSet(picks: IntArray, minerals: Array<String>, maxSize: Int): List<FiveMineralSet> {
        val mineralSetList = mutableListOf<FiveMineralSet>()

        var indexCount = 0
        while (indexCount < maxSize){
            val tempList = mutableListOf<String>()
            var tempScore = 0
            while (tempList.size < 5 && indexCount < maxSize) {
                tempList.add(minerals[indexCount])
                when(minerals[indexCount]){
                    "diamond" -> tempScore += 25
                    "iron" -> tempScore += 5
                    "stone" -> tempScore += 1
                }
                indexCount++
            }
            mineralSetList.add(FiveMineralSet(tempList.toList(),tempScore))
        }

        return mineralSetList.sortedByDescending { it.mineralsScore }
    }
}

class FiveMineralSet(
    val mineralsList: List<String>,
    val mineralsScore: Int
)