package infraestructura.db

import entidades_negocio.User

class InMemoryDB : DB {

    override fun data(): Map<Int, User> {
        return mapOf(
            0 to User(
                id = 1,
                name = "David",
                email = "David@",
                age = 18
            ),
            1 to User(
                id = 2,
                name = "Javiera",
                email = "Javiera@",
                age = 45
            )
        )
    }
}
