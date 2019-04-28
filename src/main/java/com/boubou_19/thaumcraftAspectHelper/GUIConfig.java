package com.boubou_19.thaumcraftAspectHelper;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

import static com.boubou_19.thaumcraftAspectHelper.ThaumcraftAspectHelper.MODID;

public class GUIConfig extends GuiScreen {
    private int btnValidation;
    private GuiTextField path;


    public GUIConfig(){

    }
    public void initGui()
    {
        // btn id
        btnValidation = 0;
//        GuiButton(btn id, posX,posY,w,h,string)
        this.buttonList.add(new GuiButton(btnValidation, 130, 9, 20, 16, I18n.format(MODID+".btn.validation.name")));
//        GuiTextField(font renderer,posX,posY,w,h)
        this.path = new GuiTextField(this.fontRendererObj, 0, 10, 128, 14);
        path.setMaxStringLength(256);
        path.setText("dump.csv");
        this.path.setFocused(true);
        super.initGui();
    }
    @Override
    protected void keyTyped(char typedChar, int keyCode)
    {
        this.path.textboxKeyTyped(typedChar, keyCode);
        if(!( typedChar== Keyboard.KEY_E  &&  this.path.isFocused())) super.keyTyped(typedChar, keyCode);
    }
    @Override
    protected void actionPerformed(GuiButton button)
    {
        switch(button.id)
        {
            case 0:
                Helper.run(this.path.getText());

                break;
            default:
                break;
        }

        super.actionPerformed(button);
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();
        this.path.updateCursorCounter();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTick)
    {

        this.drawDefaultBackground();
        this.path.drawTextBox();
//        drawString(font renderer,string, posX,posY,color)
        this.drawString(this.fontRendererObj,"relative path from instance folder",0,0,0xffffff);
        this.drawString(this.fontRendererObj,"Warning: aspects from the dump may not be the same as aspects contained in items because",0,30,0xFF8000);
        this.drawString(this.fontRendererObj,"it copies the aspects from instances of the items not from the items themselves",0,40,0xFF8000);

        super.drawScreen(mouseX, mouseY, partialTick);
    }


    protected void mouseClicked(int x, int y, int btn) {
        super.mouseClicked(x, y, btn);
        this.path.mouseClicked(x, y, btn);
    }
}
