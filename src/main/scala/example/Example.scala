package example

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.entity.Player
import org.bukkit.block.data.Waterlogged
import org.bukkit.block.Block
import org.bukkit.Material

class Example extends JavaPlugin with Runnable {

    override def onEnable: Unit = {
        getLogger().info("Enabling example plugin")
        // this.getServer().getScheduler().scheduleAsyncDelayedTask(this, new CustomSpawner(this), 20)
        this.getServer().getScheduler().scheduleSyncDelayedTask(this, this, 20)
    }

    override def onDisable: Unit = getLogger().info("Disabling example plugin")

    def run(): Unit =
        this.getServer().getOnlinePlayers() forEach { player => waterLog(player) }

    def waterLog(player: Player) = {
        val playerLoc = player.getLocation()
        val pX = playerLoc.getBlockX()
        val pY = playerLoc.getBlockY()
        val pZ = playerLoc.getBlockZ()
        for (
            x <- -3 to 3;
            y <- -3 to 3;
            z <- -3 to 3
        ) {
            val b = player.getWorld().getBlockAt(pX + x, pY + y, pZ + z)
            if (b.getType() == Material.AIR) {
                setWaterlogged(b)
            }
            
        }
    }

    def setWaterlogged(b: Block): Unit = {
        b.setType(Material.SIGN)
        val bData = b.getBlockData().asInstanceOf[Waterlogged]
        bData.setWaterlogged(true)
    }
}

class CustomSpawner(val plugin: JavaPlugin) extends Runnable {

    def run(): Unit = {
        this.plugin.getLogger().info("Running custom spawner")
        // try to spawn sum mobs?

        this.plugin.getServer().getScheduler().scheduleAsyncDelayedTask(this.plugin, this, 20)
    }
}
