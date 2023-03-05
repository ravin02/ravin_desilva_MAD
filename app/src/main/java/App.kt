
fun main(){
val generatedNumber = (1000..9999).random() // generating a random number
    var guess: Int
    var n= 0
    var m= 0
    println(generatedNumber) //For testing purposes: to check whether a random number is being printed and to check if the correct guess matches with a digit of the random number

// Loop that continues until the user guesses the correct number

    do {
        print("Guess the 4-digit number: ")
        guess = readLine()?.toIntOrNull() ?: 0 // reading user's guess and making sure that by typing something wrong (e.g. char instead of int) that the program won't crash (

        if (guess < 1000 || guess > 9999) {
            println("Invalid input. Please enter a 4-digit number.")
        } else {
            // Call the compareNumbers function to compare the user's guess to the random number and
            // return a pair of integers representing the number of digits that are correct regardless of their position (nCount) and the number of digits that are correct and in their correct position (mCount).
            val (nCount, mCount) = compareNumbers(generatedNumber, guess)
            n = nCount
            m = mCount
            println("$n:$m")
        }
    } while (m < 4)

    println("YAYYYY! You guessed the 4-digit number.")
}

// Function that compares the generated number and the user's guess and returns a pair of numDigitMatch and numPositionsMatch

fun compareNumbers(generatedNumber: Int, guess: Int): Pair<Int, Int> {
    var numDigitsMatch = 0
    var numPositionsMatch = 0

    for (i in 0 until 4) { // Looping through each digit of the user's guess

        // Getting the i-th digit of the user's guess and storing it in a variable called digit

        val digit = guess.toString()[i]

        // Checking if the digit is in the correct position, if so, incrementing numPositionsMatch
        if (digit.code == generatedNumber.toString()[i].code) {
            numPositionsMatch++
        }
        // Checking if the digit is present in the generated number, if so, incrementing numDigitsMatch

        if (digit.code in generatedNumber.toString().map { it.code }) {
            numDigitsMatch++
        }
    }

    return Pair(numDigitsMatch, numPositionsMatch)
}







