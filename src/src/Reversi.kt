fun initializeBoard(): MutableMap<Pair<Int, Int>, String> {

    val reversi = mutableMapOf<Pair<Int, Int>, String>()
//sets a pair for the position on the board and value to "-"
    for (row in 0 until 8) {
        for (column in 0 until 8) {
            reversi[Pair(row, column)] = "-"
        }
    }

    return reversi
}

fun printBoard(board: Map<Pair<Int, Int>, String>) {
    // prints the board according to a position with a value - gives the board a look
    // $col and $row prints number for the board, thosae are additional
    print("  ")
    for (col in 0 until 8) {
        print("$col ")
    }
    println("Y")
    for (row in 0 until 8) {
        print("$row ")
        for (column in 0 until 8) {
            print("${board[Pair(row, column)]} ")
        }
        println()
    }
    println("X")
}

//--------------PLAYERS---------------
var player1name = println("Enter player 1 name: ")
var player1 = readln()
var plazer2name = println("Enter player Two name: ")
var player2 = readln()

val reversi = initializeBoard()

// making moves and checking if space is free
fun move(player: String){

    println("$player, make your move")
    println("give x:")
    var x = readln().toInt()
    println("give y:")
    var y = readln().toInt()
    var xy = ""
    if (player === player1) {
        if (reversi[Pair(x, y)] === "-" &&
            reversi[Pair(x, y + 1)] === "=" || reversi[Pair(x + 1, y)] === "=" || reversi[Pair(x + 1, y + 1)] === "="
            || reversi[Pair(x, y - 1)] === "=" || reversi[Pair(x - 1, y)] === "=" || reversi[Pair(x - 1, y - 1)] === "="
        ) {
            reversi[Pair(x, y)] = "+"
            //xy = "+"
            gameplay1(x, y)
        } else {
            println("Invalid, you lost your move!")
            Thread.sleep(1000L)
        }
    } else if (player === player2) {
        if (reversi[Pair(x, y)] === "-" &&
            reversi[Pair(x, y + 1)] === "+" || reversi[Pair(x + 1, y)] === "+" || reversi[Pair(x + 1, y + 1)] === "+" ||
            reversi[Pair(x, y - 1)] === "+" || reversi[Pair(x - 1, y)] === "+" || reversi[Pair(x - 1, y - 1)] === "+"
        ) {
            reversi[Pair(x, y)] = "="
            //xy = "="
            gameplay2(x, y)
        } else {
            println("Invalid, you lost your move!")
            Thread.sleep(1000L)
        }
    }
    //return xy

}

fun gameplay1(row: Int, col: Int) {
    for (col in 0 until 8) {
        if (reversi[Pair(row, col)] === "=") {
            reversi[Pair(row, col)] = "+"
        }
    }
    for (row in 0 until 8) {
        if (reversi[Pair(row, col)] === "=") {
            reversi[Pair(row, col)] = "+"
        }
    }//vorsicht
  // while(reversi[Pair(row+1, col)] === "="){
    //   reversi[Pair(row+1, col)] = "+"


}
//++, --, -+,+-
fun gameplay2(row: Int, col: Int) {
    for (col in 0 until 8) {
        if (reversi[Pair(row, col)] === "+") {
            reversi[Pair(row, col)] = "="
        }
    }
    for (row in 0 until 8) {
        if (reversi[Pair(row, col)] === "+") {
            reversi[Pair(row, col)] = "="
        }
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {


    //--------------BOARD----------------


    // Place some initial pieces on the board for demonstration purposes
    reversi[Pair(3, 3)] = "+"
    reversi[Pair(3, 4)] = "="
    reversi[Pair(4, 3)] = "="
    reversi[Pair(4, 4)] = "+"


    printBoard(reversi)

println("+ starts!")
    //moves
while (reversi.containsValue("-")){
    println(move(player1))
    printBoard(reversi)
    println(move(player2))
    printBoard(reversi)
}
    //
    //
    //
    //
}