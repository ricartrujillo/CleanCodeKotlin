package user.services

interface UserService {
    fun validateUserOfLegalAge(id: Int): Pair<String, Error>
}
