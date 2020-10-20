package user.services

import user.repository.UserRepository

class UserServiceImpl(private val repository: UserRepository) : UserService {

    override fun validateUserOfLegalAge(id: Int): Pair<String, Error> {
        val userResponse = repository.getUserByID(id)
        return repository.getUserByID(id).first
            .takeIf { it.name.isNotBlank() }?.let { user ->
                user.takeIf { it.age > 18 }?.let {
                    Pair("Welcome ${it.name}", Error())
                } ?: Pair("Error", Error("The user is not of legal age"))
            } ?: Pair("Error", userResponse.second)
    }
}
