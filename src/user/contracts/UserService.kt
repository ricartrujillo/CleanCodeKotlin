package user.contracts

interface UserService {
    fun validateUserOfLegalAge(id: Int): Pair<String, Error>
}
