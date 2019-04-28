package com.boubou_19.thaumcraftAspectHelper;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

import static thaumcraft.api.ThaumcraftApi.objectTags;

public class Helper {
    public static void run(String path) {
        String absolutePath = Paths.get("").toAbsolutePath().toString()+ File.separator+path+".csv";
        System.out.println("Current relative path is: " + absolutePath);
        CSVWriter file = new CSVWriter(absolutePath);
        try {
            file.writeToFile("Item/block;Aspects");
        } catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (Map.Entry<List, AspectList> entry : objectTags.entrySet()) {
            List stuff = entry.getKey();
            try {
                String stuffName = new ItemStack((Item) stuff.get(0), 1, (Integer) stuff.get(1)).getDisplayName();

                AspectList listOfAspectsForItem = entry.getValue();
                Aspect[] tri = listOfAspectsForItem != null ? listOfAspectsForItem.getAspectsSorted() : new Aspect[0];
                List<String> AspectNames = new ArrayList<String>();
                for (Aspect aspect : tri) {
                    if (aspect != null) {
                        AspectNames.add(aspect.getName());
                    }

                }

                try {
                    if (AspectNames.size()>=1) {

                        AspectNames.add(0, stuffName);
//                        System.out.println(stuffName + " : Aspects: " + String.join(";", AspectNames));
                        file.writeToFile(String.join(";", AspectNames));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }catch(ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        file.close();
    }
}
