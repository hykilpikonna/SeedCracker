package kaptainwutax.seedcracker.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.TextComponentUtil;
import net.minecraft.text.Texts;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;

import static net.minecraft.util.Formatting.RED;
import static net.minecraft.util.Formatting.YELLOW;

public class Log {

    public static void debug(String message) {
        PlayerEntity player = getPlayer();

        if(player != null) {
            player.addChatMessage(new LiteralText(message), false);
        }
    }

    public static void warn(String message) {
        PlayerEntity player = getPlayer();

        if(player != null) {
            player.addChatMessage(new LiteralText(YELLOW + message), false);
        }
    }

    public static void error(String message) {
        PlayerEntity player = getPlayer();

        if(player != null) {
            player.addChatMessage(new LiteralText(RED + message), false);
        }
    }

    private static PlayerEntity getPlayer() {
        return MinecraftClient.getInstance().player;
    }

}
