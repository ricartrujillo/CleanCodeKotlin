package test.user.services

import entidades_negocio.User
import user.contracts.UserRepository
import user.services.UserServiceImpl

internal class UserServiceImplTest {

    fun whenValidatingTheUserAgeWithAnEmptyUserThenReturnsTheErrorMessageNoUserFound() {
        val userRepository = object: UserRepository {
            override fun getUserByID(userId: Int): Pair<User, Error> {
                return Pair(User(), Error("No user found"))
            }
        }
        val userService = UserServiceImpl(userRepository)

        val response = userService.validateUserOfLegalAge(0)

        check(response.second.message.equals("No user found"))
    }

    fun whenValidatingTheUserAgeWithAnUnderageUserThenReturnsTheErrorMessageNoUserFound() {
        val userRepository = object: UserRepository {
            override fun getUserByID(userId: Int): Pair<User, Error> {
                return Pair(User(name = "Pepe", age = 16), Error("No user found"))
            }
        }
        val userService = UserServiceImpl(userRepository)

        val response = userService.validateUserOfLegalAge(0)

        check(response.second.message.equals("The user is not of legal age"))
    }
}
