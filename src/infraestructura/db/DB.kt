package infraestructura.db

import entidades_negocio.User

interface DB {
    fun data(): Map<Int, User>
}
