package rekteiru.hotshirtlessmen;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class hsmCommands extends CommandBase implements ICommand {

    @Override
    public String getCommandName() {
        return "hsm";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "§2Use /hsm help for list of commands";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args == null || args.length == 0) {
            main.mc.thePlayer.addChatMessage(new ChatComponentText("§2Use /hsm help for list of commands"));
        } else {
            int length = args.length;
            switch (args[0]) {
                case "help":
                    main.mc.thePlayer.addChatMessage(new ChatComponentText("§2List of commands:\n§a/hsm drill [on/off] to toggle drill fix"));
                    break;
                case "drill":
                    if (length > 1 && (args[1].equals("on") || args[1].equals("off"))) {
                        main.DRILL_TOGGLE = args[1].equals("on");
                    } else {
                        main.DRILL_TOGGLE = !main.DRILL_TOGGLE;
                    }
                    chatCommandFeedback(main.DRILL_TOGGLE,"DrillFix");
                    break;
                default:
                    main.mc.thePlayer.addChatMessage(new ChatComponentText("§2Use /hsm help for list of commands"));
                    break;
            }
        }
    }

    private void chatCommandFeedback(Boolean bool, String type) {
        if (!type.isEmpty()) {
            type = "§b§l" + type;
            if (bool) {
                type += " §2ON";
            } else {
                type += " §4OFF";
            }
            main.mc.thePlayer.addChatMessage(new ChatComponentText(type));
        }
    }
}
