package com.labygame.sauvegarde;

import com.labygame.personnage.Hero;
import org.jetbrains.annotations.NotNull;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Save {

    /**
     * Method who save an object progress.
     * @param heroToSave the object statement.
     */
    public static void saveHero(@NotNull Hero heroToSave){
        try {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("saveHero.json"),heroToSave);
    }catch (IOException e){
        e.printStackTrace();
    }
    }

    /**
     * This function recovers the Hero's backup.
     * @return the Hero saved.
     */
    public static Hero recuperationSaveHero(){
        Hero hero = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            hero = objectMapper.readValue(new File("saveHero.json"), Hero.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return hero;
    }
}
