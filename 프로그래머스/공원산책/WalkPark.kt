fun main(){
    Solution().solution(arrayOf("SOO","OOO","OOO"), arrayOf("E 2","S 2","W 1"))
}

class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var xy = Xy(0,0)

        for(y in park.indices){
            for(x in park[y].indices){
                if(park[y][x] == 'S'){
                    xy.x = x
                    xy.y = y
                }
            }
        }
        println("${routes[2][2].toString().toInt()}")
        routes.forEach{ string ->
            xy = checkMovable(park,string[0],string[2].toString().toInt(),xy)
        }


        return intArrayOf(xy.y,xy.x)
    }

    fun checkMovable(park: Array<String>, direc: Char, length: Int, xy: Xy): Xy{
        val resultXY = xy.copy()
        when(direc){
            'N'->{
                if(xy.y - length >= 0){
                    for(i in (xy.y - length) .. xy.y){
                        if(park[i][xy.x] == 'X') {break}
                        if(i == xy.y) {resultXY.y -= length}
                    }
                }
            }
            'S'->{
                if(xy.y + length < park.size){
                    for(i in xy.y .. xy.y + length){
                        if(park[i][xy.x] == 'X') {break}
                        if(i == xy.y + length) {resultXY.y += length}
                    }
                }
            }
            'W'->{
                if(xy.x - length >= 0){
                    for(i in (xy.x - length) .. xy.x){
                        if(park[xy.y][i] == 'X') {break}
                        if(i == xy.x) {resultXY.x -= length}
                    }
                }
            }
            'E'->{
                if(xy.x + length < park[0].length){
                    print("E")
                    for(i in (resultXY.x)..(resultXY.x + length)){
                        print(i)
                        if(park[xy.y][i] == 'X') {
                            print("breakE")
                            break
                        }
                        if(i == xy.x + length) {resultXY.x += length;print(resultXY)}
                    }
                }
            }
        }
        // print(resultXY)
        return resultXY
    }
}

data class Xy(
    var x: Int,
    var y: Int,
)