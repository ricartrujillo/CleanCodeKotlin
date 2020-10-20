package user.repository

import entidades_negocio.User
import infraestructura.db.DB

class UserRepositoryImpl(private val database: DB) : UserRepository {

    override fun getUserByID(userId: Int): Pair<User, Error> {
        return database.data()[userId]?.let {
            Pair(it, Error())
        } ?: Pair(User(), Error("Register not found"))
    }
}
