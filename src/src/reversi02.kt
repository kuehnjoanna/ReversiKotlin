fun main(){
    // Place some initial pieces on the board for demonstration purposes
  /*  reversi2[Pair(3, 3)] = "+"
    reversi2[Pair(3, 4)] = "="
    reversi2[Pair(4, 3)] = "="
    reversi2[Pair(4, 4)] = "+"
   ┌───┐
            │   │
            └───┘

   */

    printBoard2(reversi2)
   // printReversiBoard(reversi2)
}

val reversi2 = initializeBoard2()
fun initializeBoard2(): MutableMap<Pair<Int, Int>, String> {

    val reversi2 = mutableMapOf<Pair<Int, Int>, String>()
//sets a pair for the position on the board and value to "-"
    for (row in 0 until 8 ) {
        for (column in 0 until 8) {

            reversi2[Pair(row, column)] = " - "


        }

    }
    return reversi2
}

fun printBoard2(board: Map<Pair<Int, Int>, String>) {
    // prints the board according to a position with a value - gives the board a look
    // $col and $row prints number for the board, thosae are additional
    print("    ")
    for (col in 0 until 8) {

        print(" $green $col$reset    ")

    }
    println("  Y  ")
    for (row in 0 until 1) {
        for (col in 0 until 1) {

            print("  ")
        }
        print(
            """
      $red$frameUp$frameUp$frameUp█▀▀█$reset
        """.trimIndent()
        )}
    print("\n")
    for (row in 1 until 8) {
        print(
            """
              $red█${reset}┌─────┐┌─────┐┌─────┐┌─────┐┌─────┐┌─────┐┌─────┐┌─────┐${red}█$reset
            $green$row $red█$reset
        """.trimIndent()
        )

        counter++

print("")
        for (column in 0 until 8) {

            print("|")
            print(" ${board[Pair(row, column)]} ")

            print("|")
        }
print("$red█$reset")
        print("\n $red █${reset}└─────┘└─────┘└─────┘└─────┘└─────┘└─────┘└─────┘└─────┘")
        println("$red█$reset")

    }


        print(red + "  $frame$frame$frame█▄█▀▀█▄█▀▀█▄█" + reset)

    println("\nX")
}


