package kaptainwutax.seedcracker.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import kaptainwutax.seedcracker.finder.Finder;
import kaptainwutax.seedcracker.finder.FinderQueue;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import static kaptainwutax.seedcracker.SeedCracker.GUI_ITEM;
import static net.minecraft.server.command.CommandManager.literal;

public class GuiCommand extends ClientCommand {

    @Override
    public String getName() {
        return "gui";
    }

    @Override
    public void build(LiteralArgumentBuilder<ServerCommandSource> builder) {
        builder.executes(ctx->
        {
            ServerCommandSource source = ctx.getSource();

            ClientPlayerEntity self =(ClientPlayerEntity) source.getEntity();
            assert self != null;
            if(!self.inventory.insertStack(new ItemStack(GUI_ITEM))){
                throw new SimpleCommandExceptionType(new TranslatableText("inventory.isfull")).create();
            }
            return 1;
        });
    }



}
