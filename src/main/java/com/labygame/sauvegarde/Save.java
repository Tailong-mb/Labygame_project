package com.labygame.sauvegarde;

import com.google.gson.Gson;
import com.labygame.items.Item;
import com.labygame.personnage.Hero;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Save {

    /**
     * Method who save an object progress.
     * @param heroToSave the object statement.
     */
    public static void saveHero(@NotNull Hero heroToSave){
        Gson gson = new Gson();
        //Write hero statement
        try{
            Writer writer = Files.newBufferedWriter(Paths.get("saveHero.json"));
            gson.toJson(heroToSave,writer);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //write item statement
        try{
            Writer writer = Files.newBufferedWriter(Paths.get("saveItem.json"));
            gson.toJson(new HashMap<>(heroToSave.getMyItem()),writer);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This function recovers the Hero's backup.
     * @return the Hero saved.
     */
    public static Hero recuperationSaveHero(){
        Gson gson = new Gson();
        //Recuperation of Hero save
        try{
            String file = "saveHero.json";
            String jsonString = new String(Files.readAllBytes(Paths.get(file)));
            Hero heroSaved = gson.fromJson(jsonString, Hero.class);
        //Recuperation of item save
            String newFile = "saveItem.json";
            Reader reader = Files.newBufferedReader(Paths.get(newFile));
            HashMap<Item,Integer> itemSaved = gson.fromJson(reader, HashMap.class);
            heroSaved.setMyItem(itemSaved);
            return heroSaved;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
