var table = arrayOf(
    arrayOf(" ","1","2","3"),
    arrayOf("1","-","-","-"),
    arrayOf("2","-","-","-"),
    arrayOf("3","-","-","-")
)
var rowInd = 0
var colInd = 0

fun printTable(){
    for (row in table){
        for (col in row){
            print("$col ")
        }
        println()
    }
}

fun input(x:String){
    while (true){
        try {
            print("Please in Row Col: ")
            val input = readLine()
            val rcList = input?.split(" ")
            if (rcList?.size != 2){
                println("Error: input 2 numbers Row Col (Ex: 1 2)")
                continue
            }
            rowInd = rcList[0].toInt()
            colInd = rcList[1].toInt()
            if((rowInd < 1 && colInd < 1) || (rowInd > 3 && colInd > 3)) {
                println("Error: out of table")
                continue
            }
            if (table[rowInd][colInd] == "X" || table[rowInd][colInd] == "O"){
                println("Error: This position has been used")
                continue
            }
            table[rowInd][colInd] = x
            break
        }catch (t: Throwable){
            println("Error: ${t.message} is not a number (Ex: 1 2)")
        }
    }
}
fun CheckWin():Boolean {
    for(row in 1..3){
        if ((table[row][1] == table[row][2] && table[row][1] == table[row][3])){
            if (table[row][1] != "-") {
                return true
            }
        }

    }
    for (col in 1..3) {
        if ((table[1][col] == table[2][col] && table[1][col] == table[3][col])) {
           if (table[1][col] != "-") {
               return true
           }
        }
    }
    if (table[2][2] != "-"){
        if ((table[1][1] == table[2][2] && table[1][1] == table[3][3])){
            return true
        }
        if ((table[3][1] == table[2][2] && table[3][1] == table[1][3])){
            return true
        }
    }
    return false
}

fun main() {
    var round = 1
    printTable()
    while (true){

        if (round%2 == 1){
            println("X Turn")
            input("X")
        }else{
            println("O Turn")
            input("O")
        }
        printTable()
        if (CheckWin()){
            break
        }
        round++
    }
    if (round%2 == 1){
        print("X Win")
    }else{
        print("O Win")
    }


}