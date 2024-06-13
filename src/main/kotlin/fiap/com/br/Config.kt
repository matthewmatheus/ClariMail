package fiap.com.br


import io.ktor.server.config.*
import com.typesafe.config.ConfigFactory

object Config {
    private val config = HoconApplicationConfig(ConfigFactory.load())

    val databaseUrl: String = config.property("database.url").getString()
    val databaseDriver: String = config.property("database.driver").getString()
    val databaseUser: String = config.property("database.user").getString()
    val databasePassword: String = config.property("database.password").getString()
}
