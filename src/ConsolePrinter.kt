object ConsolePrinter {
    const val RED = "\u001b[0;31m"
    const val GREEN = "\u001b[0;32m"
    private const val RESET = "\u001b[0m"

    fun printToConsole(color: String, message: String) {
        println(color + message + RESET)
    }
}
