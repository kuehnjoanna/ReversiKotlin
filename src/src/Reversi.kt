
//------------BOARD---------------
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
//var player1name = println("Enter player 1 name: ")
var player1 = "+"
//var plazer2name = println("Enter player Two name: ")
var player2 = "="
fun switchPlayer() {
    currentPlayer = if (currentPlayer == player1) player2 else player1
}


val reversi = initializeBoard()


var currentPlayer = player1
//---------------------VALID MOVES------------------------
// valid move condition, checks if there are any on the board
fun hasAMove(board: Map<Pair<Int, Int>, String>, player: String): Boolean {
    for (row in 0 until 8) {
        for (column in 0 until 8) {
            if (hasValidMove(board, row, column)) {
                return true
            }
        }
    }
    return false
}

// defines valid move based on cur player and readln position
fun hasValidMove(board: Map<Pair<Int, Int>, String>, x: Int, y: Int): Boolean {
    if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[Pair(x, y)] != "-") {
        return false
    }
    return true
}
//-------POINTS------
fun countPoints(board: Map<Pair<Int, Int>, String>, player: String): Int {
    return board.count { it.value == player }
}

//------------MOVE------------
fun makeMove(board: MutableMap<Pair<Int, Int>, String>, x: Int, y: Int) {
    val originalBoard = board.toMutableMap()  // Create a copy of the original board
    var tilesFlipped = 0

    board[Pair(x, y)] = currentPlayer

    // check tiles for changes
    for (dx in -1..1) {
        for (dy in -1..1) {
            // Skip the cur position (x, y)
            if (dx == 0 && dy == 0) continue

            var currentX = x + dx
            var currentY = y + dy
            var tilesToFlip = mutableListOf<Pair<Int, Int>>()

            // Check for tiles to flip
            val opponentPlayer = if (currentPlayer == player1) player2 else player1
            while (board[Pair(currentX, currentY)] == opponentPlayer) {
                tilesToFlip.add(Pair(currentX, currentY))
                currentX += dx
                currentY += dy
            }

            // If next tile is the player's tile - flip
            if (board[Pair(currentX, currentY)] == currentPlayer) {
                tilesToFlip.forEach { flippedTile ->
                    board[flippedTile] = currentPlayer
                    tilesFlipped++
                }
            }
        }
    }

    if (tilesFlipped == 0) {
        println("Invalid move.")
        board.clear()
        board.putAll(originalBoard)
    }

}

fun ifWinner (){
    println("ifWinner")
    val pointsPlayer1 = countPoints(reversi, player1)
    val pointsPlayer2 = countPoints(reversi, player2)
    println(reversi.containsValue("="))
    println(reversi.containsValue("+"))

    if (!hasAMove(reversi, player1) && !hasAMove(reversi, player2)){
        println("Game over! Points:")
        println("$player1: $pointsPlayer1 points")
        println("$player2: $pointsPlayer2 points")
    } else if (reversi.containsValue("+") && reversi.containsValue("-")) {
        // Game over - count and print points
        printBoard(reversi)
    } else {
        println("Game over! Points:")
        println("$player1: $pointsPlayer1 points")
        println("$player2: $pointsPlayer2 points")
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


    while (countPoints(reversi, currentPlayer) > 0) {
        // Example usage after getting user input for x and y
        println("$currentPlayer, make your move")
        val x = readLine()?.toIntOrNull() ?: continue
        val y = readLine()?.toIntOrNull() ?: continue

        if (!hasValidMove(reversi, x, y)) {
            println("Invalid move. Try again.")
            continue
        }

        makeMove(reversi, x, y)

       printBoard(reversi)

        switchPlayer()

        if (!hasAMove(reversi, player1) && !hasAMove(reversi, player2)) {
            break
        }



    }


    println("Game over! Points:")
    println("$player1: ${countPoints(reversi, player1)} points")
    println("$player2: ${countPoints(reversi, player2)} points")

}