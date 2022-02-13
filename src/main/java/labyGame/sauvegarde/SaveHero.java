package labyGame.sauvegarde;

import labyGame.personnage.Hero;

import java.io.*;

public class SaveHero {

    /**
     * Method who save the hero progress.
     * @param heroSave the hero statement.
     */
    public static void saveHero(Hero heroSave){
        try{
            File outFile = new File("HeroSave.txt");
            OutputStream file = new FileOutputStream(outFile);
            ObjectOutputStream myWriter = new ObjectOutputStream(file);
            myWriter.writeObject(heroSave);
            myWriter.close();
        }catch (IOException e){
            System.out.println("An IOEXCEPTION error occurred");
            e.printStackTrace();
        } catch (Exception z){
            System.out.println("An Exception error occurred");
        }
    }

    /**
     * This function recovers the Hero's backup.
     * @return the Hero saved.
     */
    public static Hero recupSaveHero(){
        Hero heroSaved = null;
        try {
            File outFile = new File("HeroSave.txt");
            InputStream file = new FileInputStream(outFile);
            ObjectInputStream myReader = new ObjectInputStream(file);
            heroSaved = (Hero) myReader.readObject();
            myReader.close();
        } catch (IOException e) {
            System.out.println("An IOEXCEPTION error occurred");
            e.printStackTrace();

        } catch (Exception z) {
            System.out.println("An Exception error occurred");
        }
        if(heroSaved == null)
            throw new IllegalAccessError("No save");
        else
        return heroSaved;
    }
}
