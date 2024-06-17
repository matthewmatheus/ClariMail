package fiap.com.br.models



import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.javatime.CurrentDateTime

object Users : IntIdTable() {
    val username = varchar("username", 50).uniqueIndex()
    val password = varchar("password", 100)
    val email = varchar("email", 100).uniqueIndex()
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime)
}

