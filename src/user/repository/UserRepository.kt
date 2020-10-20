package user.repository

import entidades_negocio.User

interface UserRepository {
    fun getUserByID(userId: Int): Pair<User, Error>
}
