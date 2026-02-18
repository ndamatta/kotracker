import java.util.Scanner

fun main() {

    val scanner = Scanner(System.`in`)
    val tracker = ExpenseTracker()
    var running = true

    while (running) {

        clearConsole()

        println("Kotracker | Expense tracker\n")
        println("1. Add expense")
        println("2. Show all expenses")
        println("3. Show total expenses")
        println("4. Show expenses by category")
        println("5. Edit expense")
        println("6. Delete expense")
        println("7. Exit")
        print("\nChoose an option: ")

        val option = scanner.nextLine()

        clearConsole()

        when (option) {
            "1" -> tracker.addExpense(scanner)
            "2" -> tracker.showAllExpenses()
            "3" -> tracker.showTotalExpenses()
            "4" -> tracker.showExpensesByCategory()
            "5" -> tracker.editExpense(scanner)
            "6" -> tracker.deleteExpense(scanner)

            "7" -> {
                println("Goodbye")
                running = false
            }

            else -> {
                println("Invalid option")
                println("\nPress Enter to continue...")
                readln()
            }
        }
    }
}
