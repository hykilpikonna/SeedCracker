package kaptainwutax.seedcracker.gui;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import kaptainwutax.seedcracker.SeedCracker;
import kaptainwutax.seedcracker.finder.FinderQueue;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class Gui extends LightweightGuiDescription {
    public Gui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(256, 240);

        WSprite icon = new WSprite(new Identifier("minecraft:textures/item/redstone.png"));
        root.add(icon, 0, 2, 1, 1);

        WButton button = new WButton(new TranslatableText("RESET DATA"));
        button.setOnClick(new Runnable() {
                              @Override
                              public void run() {
                                  SeedCracker.get().getDataStorage().clear();
                                  FinderQueue.get().clear();
                              }
                          }
        );
        root.add(button, 0, 3, 4, 1);

        WLabel label = new WLabel(new LiteralText("Test"), 0xFFFFFF);
        root.add(label, 0, 4, 2, 1);

        root.validate(this);
    }


    @Override
    public void addPainters() {
        getRootPanel().setBackgroundPainter(BackgroundPainter.VANILLA); //This is done automatically though
    }
}
