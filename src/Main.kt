import ConsolePrinter.printToConsole
import infraestructura.db.DB
import infraestructura.db.InMemoryDB
import test.user.services.UserServiceImplTest
import user.contracts.UserRepository
import user.repository.UserRepositoryImpl
import user.contracts.UserService
import user.services.UserServiceImpl

fun main() {
    val database: DB = InMemoryDB()
    val repository: UserRepository = UserRepositoryImpl(database)
    val service: UserService = UserServiceImpl(repository)

    fetchUser(service, 0)
    fetchUser(service, 1)
    fetchUser(service, 2)

    runTests()
}

fun runTests() {
    UserServiceImplTest().whenValidatingTheUserAgeWithAnEmptyUserThenReturnsTheErrorMessageNoUserFound()
    UserServiceImplTest().whenValidatingTheUserAgeWithAnUnderageUserThenReturnsTheErrorMessageNoUserFound()
}

private fun fetchUser(service: UserService, userId: Int) {
    val response: Pair<String, Error> = service.validateUserOfLegalAge(userId)
    response.second.message?.takeIf { it.isNotBlank() }?.let {
        printToConsole(ConsolePrinter.RED, it)
    } ?: printToConsole(ConsolePrinter.GREEN, response.first)
}
