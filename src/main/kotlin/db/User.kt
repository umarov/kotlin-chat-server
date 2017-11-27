package db

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object Users : IntIdTable() {
    val username = varchar("username", 50).index()
    val name = varchar("name", 100)
    val token = varchar("token", 200)
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var username by Users.username
    var name by Users.name
    var token by Users.token
    var messages by Message referrersOn Messages.user
}