package rekteiru.hotshirtlessmen;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;

@Mod(modid = "hotshirtlessmen", useMetadata=true)
public class main {
    public static final String modid = "hotshirtlessmen";
    public static boolean DRILL_TOGGLE = true;
    public static ItemStack previousItem = null;
    public static Minecraft mc = Minecraft.getMinecraft();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new hsmCommands());
    }

}
