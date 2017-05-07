package kriptikz.archmage.client.gui;

import java.io.IOException;

import kriptikz.archmage.Reference;
import kriptikz.archmage.capability.archmagelevel.ArchmageLevelProvider;
import kriptikz.archmage.capability.archmagelevel.IArchmageLevel;
import kriptikz.archmage.capability.mana.IMana;
import kriptikz.archmage.capability.mana.ManaProvider;
import kriptikz.archmage.capability.spelldata.ISpells;
import kriptikz.archmage.capability.spelldata.SpellsProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiMain extends GuiScreen
{
    // gui background texture
    private ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/archmage_gui_background.png");
    private ResourceLocation iconBackground = new ResourceLocation(Reference.MODID, "textures/gui/icon_background.png");
    private ResourceLocation fireballIcon = new ResourceLocation(Reference.MODID, "textures/entity/projectiles/fireball.png");
    
    int guiWidth = 256;
    int guiHeight = 202;
    
    // create button objects.
    
    @Override
    public void initGui()
    {
        // clear button list in case of potential leftover buttons.
        buttonList.clear();
        
        // add buttons using this.buttonList.add()
    }
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        
        int centerX = (width / 2) - guiWidth / 2;
        int centerY = (height / 2) - guiHeight / 2;
        IArchmageLevel archmageLevel = Minecraft.getMinecraft().player.getCapability(ArchmageLevelProvider.ARCHMAGE_LEVEL, null);
        IMana mana = Minecraft.getMinecraft().player.getCapability(ManaProvider.MANA, null);
        ISpells spells= Minecraft.getMinecraft().player.getCapability(SpellsProvider.SPELLS, null);
        
        GlStateManager.pushMatrix();
        {
            GlStateManager.color(1, 1, 1,1);
            Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
            drawTexturedModalRect(centerX, centerY, 0, 0, guiWidth, guiHeight);
        }
        GlStateManager.popMatrix();
        
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(centerX + guiWidth / 13, centerY + guiHeight / 17, 0);
            GlStateManager.scale(1.5, 1.5, 1.5);
            fontRendererObj.drawString("Archmage", 0, 0, 0x000000);
        }
        GlStateManager.popMatrix();
        
        // Draw Level Text
        fontRendererObj.drawString("Level: " + archmageLevel.getArchmageLevel(), centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.2), 0x000000);
        
        // Draw XP Text
        fontRendererObj.drawString("XP:", centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.25), 0x000000);
        fontRendererObj.drawString("    " + (int) archmageLevel.getLevelXp() + "/" + (int) archmageLevel.getLevelMaxXp(), centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.25), 0x006121);
        
        // Draw Mana Text
        fontRendererObj.drawString("Mana:", centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.3), 0x000000);
        fontRendererObj.drawString("       " + (int) mana.getMana() + "/" + (int) mana.getMaxMana(), centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.3), 0x0026FF);
        
        // Draw Selected Spell Text
        fontRendererObj.drawString("Selected Spell:", centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.35), 0x000000);
        
        // Draw Selected Spell Icon
        GlStateManager.pushMatrix();
        {
            GlStateManager.color(1, 1, 1,1);
            GlStateManager.translate(centerX + (int) (guiWidth * 0.33), centerY + (int) (guiHeight * 0.33), 0);
            
            GlStateManager.pushMatrix();
            {
                GlStateManager.color(1, 1, 1,1);
                Minecraft.getMinecraft().getTextureManager().bindTexture(iconBackground);
                drawModalRectWithCustomSizedTexture(0, 0, 0, 0, 16, 16, 16, 16);
            }
            GlStateManager.popMatrix();
            
            switch(spells.getSelectedSpell())
            {
                case NONE:
                    Minecraft.getMinecraft().renderEngine.bindTexture(fireballIcon);
                    break;
                case FIREBALL:
                    Minecraft.getMinecraft().renderEngine.bindTexture(fireballIcon);
                    break;
                default:
                    Minecraft.getMinecraft().renderEngine.bindTexture(iconBackground);
                    break;
            }    
            
            GlStateManager.translate(1.5, 1.5, 0);
            GlStateManager.scale(0.8, 0.8, 0.8);
            drawModalRectWithCustomSizedTexture(0, 0, 0, 0, 16, 16, 16, 16);
        }
        GlStateManager.popMatrix();
        
        // Draw Selected Spell Level Text
        fontRendererObj.drawString("5", centerX + (int) (guiWidth * 0.15), centerY + (int) (guiHeight * 0.425), 0x000000);
        
        // Draw Hotkey Text
        fontRendererObj.drawString("HotKeys:", centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.50), 0x000000);
        fontRendererObj.drawString("1:", centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.57), 0x000000);
        fontRendererObj.drawString("2:", centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.64), 0x000000);
        fontRendererObj.drawString("3:", centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.71), 0x000000);
        fontRendererObj.drawString("4:", centerX + (int) (guiWidth * 0.2), centerY + (int) (guiHeight * 0.57), 0x000000);
        fontRendererObj.drawString("5:", centerX + (int) (guiWidth * 0.2), centerY + (int) (guiHeight * 0.64), 0x000000);
        fontRendererObj.drawString("6:", centerX + (int) (guiWidth * 0.2), centerY + (int) (guiHeight * 0.71), 0x000000);
        
        // Draw Spell Sets Text
        fontRendererObj.drawString("Spell Sets:", centerX + (int) (guiWidth * 0.03), centerY + (int) (guiHeight * 0.78), 0x000000);
        
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        // TODO Auto-generated method stub
        super.actionPerformed(button);
    }

    @Override
    public void updateScreen()
    {
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
}
