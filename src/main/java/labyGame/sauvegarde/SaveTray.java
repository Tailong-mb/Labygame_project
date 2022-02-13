package labyGame.sauvegarde;

import labyGame.trayEnvironnement.labyTray;

import java.io.*;

public class SaveTray {

    /**
     * Method who save the labyTray progress.
     * @param labyTraySave the labyTray statement.
     */
    public static void saveTray(labyTray labyTraySave){
        try{
            File outFile = new File("labyTraySave.txt");
            OutputStream file = new FileOutputStream(outFile);
            ObjectOutputStream myWriter = new ObjectOutputStream(file);
            myWriter.writeObject(labyTraySave);
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
    public static labyTray recupSaveTray(){
        labyTray labyTraySaved = null;
        try {
            File outFile = new File("traySave.txt");
            InputStream file = new FileInputStream(outFile);
            ObjectInputStream myReader = new ObjectInputStream(file);
            labyTraySaved = (labyTray)  myReader.readObject();
            myReader.close();
        } catch (IOException e) {
            System.out.println("An IOEXCEPTION error occurred");
            e.printStackTrace();

        } catch (Exception z) {
            System.out.println("An Exception error occurred");
        }
        if(labyTraySaved == null)
            throw new IllegalAccessError("No save");
        else
            return labyTraySaved;
    }
}
