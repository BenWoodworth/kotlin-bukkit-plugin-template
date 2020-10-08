import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Level

class MyPlugin : JavaPlugin() { //TODO Change package and rename
    companion object {
        @JvmStatic
        lateinit var instance: MyPlugin
            private set

        internal fun log(message: String, level: Level = Level.INFO) {
            instance.logger.log(level, message)
        }
    }

    init {
        instance = this
    }

    override fun onEnable() {
        log("Hello, world!") //TODO Implement onEnable()
    }

    override fun onDisable() {
        log("Good bye, world!") //TODO Implement onDisable()
    }
}
