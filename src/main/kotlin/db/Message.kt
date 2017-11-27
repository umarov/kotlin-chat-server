package db

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable


object Messages : IntIdTable() {
    val text = varchar("text", 500)
    val createdAt = datetime("createdAt").index()
    val user = reference("user", Users)
}

class Message(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Message>(Messages)

    var text by Messages.text
    var createdAt by Messages.createdAt
    var user by User referencedOn Messages.user
}