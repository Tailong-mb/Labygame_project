package labyGame.sauvegarde;

import labyGame.personnage.Hero;
import labyGame.trayEnvironnement.labyTray;

import java.io.*;

public class Save {

    /**
     * Method who save an object progress.
     * @param objectToSave the object statement.
     */
    public static void saveObject(Object objectToSave){
        try{
            File outFile;
            if (objectToSave instanceof labyTray)
                outFile = new File("TraySave.txt");
            else
                outFile = new File("HeroSave.txt");
            OutputStream file = new FileOutputStream(outFile);
            ObjectOutputStream myWriter = new ObjectOutputStream(file);
            myWriter.writeObject(objectToSave);
            myWriter.close();
        }catch (IOException e){
            System.out.println("An IOEXCEPTION error occurred");
            e.printStackTrace();
        } catch (Exception z){
            System.out.println("An Exception error occurred");
        }
    }

    /**
     * This function recovers the tray's backup.
     * @return the tray saved.
     */
    public static labyTray recuperationSaveTray(){
        labyTray traySave = null;
        try {
            File outFile = new File("traySave.txt");
            InputStream file = new FileInputStream(outFile);
            ObjectInputStream myReader = new ObjectInputStream(file);
            traySave = (labyTray)  myReader.readObject();
            myReader.close();
        } catch (IOException e) {
            System.out.println("An IOEXCEPTION error occurred");
            e.printStackTrace();

        } catch (Exception z) {
            System.out.println("An Exception error occurred");
        }
        if(traySave == null)
            throw new IllegalAccessError("No save");
        else
            return traySave;
    }

    /**
     * This function recovers the Hero's backup.
     * @return the Hero saved.
     */
    public static Hero recuperationSaveHero(){
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
