fun main() {

    var playerChoice: String
    var computerChoice = ""

    print("Enter your Choice: Paper, Rock, Scissors: ")
    playerChoice = readln().capitalize()

    // ✅ NEW: Validate input
    if (playerChoice !in listOf("Rock", "Paper", "Scissors")) {
        println("Invalid choice! Please enter Rock, Paper, or Scissors.")
        return
    }

    val randomNumber = (1..3).random()

    when (randomNumber) {
        1 -> computerChoice = "Paper"
        2 -> computerChoice = "Rock"
        3 -> computerChoice = "Scissors"
    }

    println("Computer chose: $computerChoice")

    val winstate = when {
        playerChoice == computerChoice -> "It's a Tie!"
        playerChoice == "Paper" && computerChoice == "Rock" -> "Player Wins!"
        playerChoice == "Rock" && computerChoice == "Scissors" -> "Player Wins!"
        playerChoice == "Scissors" && computerChoice == "Paper" -> "Player Wins!"
        else -> "Computer Wins!"
    }

    println(winstate)
}
