package example

import org.bukkit.plugin.java.JavaPlugin

class Example extends JavaPlugin {

    override def onEnable: Unit = getLogger().info("Enabling example plugin")
    override def onDisable: Unit = getLogger().info("Disabling example plugin")
}
