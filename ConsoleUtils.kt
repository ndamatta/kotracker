fun clearConsole() {
    try {
        ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor()
    } catch (e: Exception) {
        repeat(50) { println() }
    }
}
