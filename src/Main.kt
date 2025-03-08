import kotlin.math.sqrt

fun main() {
   calculator()
}

fun calculator () {
    //Pick which type of calculation is desired
    println("Would you like to use basic calculator, find the square of a number or find the square root of a number?")
    println("b/s/sr")
    val calculatorType = readLine()?.lowercase()
    when (calculatorType) {
        "b" -> basicCalculator()
        "s" -> square()
        "sr" -> squareRoot()
    }
}

//Quick function for finding square of number
fun square() {
    println("What number do you want the square of?")
    val squareNumber = readLine()!!.toInt()
    val result = squareNumber * squareNumber
    println("The result is $result.")
}

//Function for finding square root of number
fun squareRoot() {
    println("What do you want the square root of?")
    val response = readLine()
    val squareRoot = response?.toDoubleOrNull()

    if (squareRoot == null || squareRoot == 0.0){
        println("The square root of a number is invalid.")
    } else {
        val result = sqrt(squareRoot)
        println("The square root of a number is $result.")
    }
}

fun basicCalculator(){
    println("Welcome to a simple Calculator")
    // Set up numbers for calculator
    var firstNumber  = 0
    var secondNumber = 0

    //Set up needed variables
    var calcContinue = true
    var result = 0
    var useResult = "n"

    //Set up a loop to continue using the calculator
    while (calcContinue) {

        // Get numbers from user
        println("Please enter the first number")
        //Add in error handling to ensure int is used
        try {
            firstNumber = readLine()!!.toInt()

            //See if result is being used
            if (result != 0 && useResult == "y") {
                secondNumber = result
            } else {
                println("Please enter the second number")
                secondNumber = readLine()!!.toInt()
            }
        } catch (e: NumberFormatException) {
            println("Invalid input, must use a number. Both numbers set to 0")
            firstNumber = 0
            secondNumber = 0
        }

        // Choose operator
        println("Please enter an operator: + - * / ")
        val operator = readLine().toString()


        //Print out the result
        when (operator) {
            "+" -> println("The result is $firstNumber + $secondNumber = ${firstNumber + secondNumber}")
            "-" -> println("The result is $firstNumber - $secondNumber = ${firstNumber - secondNumber}")
            "*" -> println("The result is $firstNumber * $secondNumber = ${firstNumber * secondNumber}")
            //Error handling for divide by 0
            "/" -> {if (secondNumber == 0)
                println("Cannot divide by 0")
            else {
                println("The result is $firstNumber / $secondNumber = ${firstNumber / secondNumber}")
            }
            }
            else -> println("Invalid operator")

        }

        //Assign the value to result based on operator
        result = when (operator) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            // Ensure the result doesn't try to divide 0
            "/" -> if (secondNumber == 0) {
                0
            } else {
                firstNumber / secondNumber
            }

            else -> {println("Invalid operator")
                0}
        }

        println("Would you like to continue using the calculator? (y/n)")
        val readContinue = readLine()?.lowercase()
        if (readContinue!! == "n") {
            calcContinue = false
        }

        if (readContinue == "n"){
            return
        } else {
            println("Would you like to use the result as the second number? (y/n)")
            useResult = readLine()?.lowercase().toString()
        }

    }
}
