package com.boubou_19.thaumcraftAspectHelper;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

import static com.boubou_19.thaumcraftAspectHelper.ThaumcraftAspectHelper.MODID;

public class GUIConfig extends GuiScreen {
    private int btnValidationDumpAspect;
    private int btnValidationDumpItem;
    private GuiTextField pathAspect;
    private GuiTextField pathItem;


    public GUIConfig(){

    }
    public void initGui()
    {
        // btn id
        btnValidationDumpAspect = 0;
        btnValidationDumpItem = 1;
//        GuiButton(btn id, posX,posY,w,h,string)

        this.buttonList.add(new GuiButton(btnValidationDumpAspect, 130, 9, 20, 16, I18n.format(MODID+".btn.validation.aspect.name")));
        this.buttonList.add(new GuiButton(btnValidationDumpItem, 130, 29, 20, 16, I18n.format(MODID+".btn.validation.item.name") ));
//        GuiTextField(font renderer,posX,posY,w,h)
        this.pathAspect = new GuiTextField(this.fontRendererObj, 0, 10, 128, 14);
        this.pathItem = new GuiTextField(this.fontRendererObj, 0, 30, 128, 14);
        pathAspect.setMaxStringLength(256);
        pathAspect.setText("dump.csv");

        pathItem.setMaxStringLength(256);
        pathItem.setText("dumpItems.csv");

        this.pathAspect.setFocused(true);
        super.initGui();
    }
    @Override
    protected void keyTyped(char typedChar, int keyCode)
    {
        this.pathAspect.textboxKeyTyped(typedChar, keyCode);
        this.pathItem.textboxKeyTyped(typedChar, keyCode);
        if(!( typedChar== Keyboard.KEY_E  &&  this.pathAspect.isFocused())) super.keyTyped(typedChar, keyCode);
    }
    @Override
    protected void actionPerformed(GuiButton button)
    {
        switch(button.id)
        {
            case 0:
                Helper.runAspect(this.pathAspect.getText());

                break;
            case 1:
                Helper.runItem(this.pathItem.getText());
            default:
                break;
        }

        super.actionPerformed(button);
    }

    @Override
    public void updateScreen()
    {
        super.updateScreen();
        this.pathAspect.updateCursorCounter();
        this.pathItem.updateCursorCounter();
    }

    public void drawScreen(int mouseX, int mouseY, float partialTick)
    {

        this.drawDefaultBackground();
        this.pathAspect.drawTextBox();
        this.pathItem.drawTextBox();
//        drawString(font renderer,string, posX,posY,color)
        this.drawString(this.fontRendererObj,"relative path from instance folder",0,0,0xffffff);
        this.drawString(this.fontRendererObj,"Warning: aspects from the dump may not be the same as aspects contained in items because",0,50,0xFF8000);
        this.drawString(this.fontRendererObj,"it copies the aspects from instances of the items not from the items themselves",0,60,0xFF8000);

        super.drawScreen(mouseX, mouseY, partialTick);
    }


    protected void mouseClicked(int x, int y, int btn) {
        super.mouseClicked(x, y, btn);
        this.pathAspect.mouseClicked(x, y, btn);
        this.pathItem.mouseClicked(x, y, btn);
    }
}
