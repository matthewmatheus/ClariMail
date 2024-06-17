package fiap.com.br
import org.jetbrains.exposed.sql.Database


object DatabaseFactory {
    fun init() {
        Database.connect(
            url = Config.databaseUrl,
            driver = Config.databaseDriver,
            user = Config.databaseUser,
            password = Config.databasePassword
        )
    }
}
