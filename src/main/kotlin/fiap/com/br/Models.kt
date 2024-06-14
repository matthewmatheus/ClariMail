package com.example

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.javatime.CurrentDateTime

object Users : IntIdTable() {
    val username = varchar("username", 50).uniqueIndex()
    val password = varchar("password", 100)
    val email = varchar("email", 100).uniqueIndex()
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime)
}

object Emails : IntIdTable() {
    val userId = reference("user_id", Users)
    val subject = varchar("subject", 255)
    val body = text("body")
    val sender = varchar("sender", 100)
    val recipient = varchar("recipient", 100)
    val sentAt = datetime("sent_at").defaultExpression(CurrentDateTime)
    val isRead = bool("is_read").default(false)
    val important = bool("important").default(false)
}
