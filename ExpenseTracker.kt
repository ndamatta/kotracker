import java.util.Scanner

class ExpenseTracker {

    private val expenses = mutableListOf<Expense>()

    fun addExpense(scanner: Scanner) {
        print("Date: ")
        val date = scanner.nextLine()

        print("Name: ")
        val name = scanner.nextLine()

        print("Category: ")
        val category = scanner.nextLine()

        print("Amount: ")
        val amount = scanner.nextLine().toDoubleOrNull() ?: 0.0

        expenses.add(Expense(date, name, category, amount))
        println("\nExpense added.")
        pressEnter()
    }

    fun showAllExpenses() {
        if (expenses.isEmpty()) {
            println("No expenses recorded.")
            pressEnter()
            return
        }

        println("All expenses:\n")
        expenses.forEachIndexed { index, e ->
            println("${index + 1}. ${e.date} | ${e.name} | ${e.category} | $${e.amount}")
        }

        pressEnter()
    }

    fun showTotalExpenses() {
        val total = expenses.sumOf { it.amount }
        println("Total expenses: $${"%.2f".format(total)}")
        pressEnter()
    }

    fun showExpensesByCategory() {
        if (expenses.isEmpty()) {
            println("No expenses recorded.")
            pressEnter()
            return
        }

        val grouped = expenses.groupBy { it.category }

        println("Expenses by category:\n")
        for ((category, list) in grouped) {
            val total = list.sumOf { it.amount }
            println("$category: $${"%.2f".format(total)}")
        }

        pressEnter()
    }

    fun deleteExpense(scanner: Scanner) {
        if (expenses.isEmpty()) {
            println("No expenses to delete.")
            pressEnter()
            return
        }

        showList()

        print("\nEnter number to delete: ")
        val index = scanner.nextLine().toIntOrNull()

        if (index == null || index !in 1..expenses.size) {
            println("Invalid selection.")
        } else {
            expenses.removeAt(index - 1)
            println("Expense deleted.")
        }

        pressEnter()
    }

    fun editExpense(scanner: Scanner) {
        if (expenses.isEmpty()) {
            println("No expenses to edit.")
            pressEnter()
            return
        }

        showList()

        print("\nEnter number to edit: ")
        val index = scanner.nextLine().toIntOrNull()

        if (index == null || index !in 1..expenses.size) {
            println("Invalid selection.")
            pressEnter()
            return
        }

        val expense = expenses[index - 1]

        print("New name (${expense.name}): ")
        val newName = scanner.nextLine()
        if (newName.isNotBlank()) expense.name = newName

        print("New category (${expense.category}): ")
        val newCategory = scanner.nextLine()
        if (newCategory.isNotBlank()) expense.category = newCategory

        print("New amount (${expense.amount}): ")
        val newAmount = scanner.nextLine().toDoubleOrNull()
        if (newAmount != null) expense.amount = newAmount

        println("Expense updated.")
        pressEnter()
    }

    private fun showList() {
        println("Current expenses:\n")
        expenses.forEachIndexed { index, e ->
            println("${index + 1}. ${e.date} | ${e.name} | ${e.category} | $${e.amount}")
        }
    }

    private fun pressEnter() {
        println("\nPress Enter to main menu...")
        readln()
    }
}
