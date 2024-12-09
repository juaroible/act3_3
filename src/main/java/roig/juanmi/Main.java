package roig.juanmi;

import java.io.File;
//import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String databasePath = "./src/database";
        String databaseName = "teachers_and_departments";
        File teachers_and_departments = new File(databasePath, databaseName);
        DatabaseManager databaseManager = new DatabaseManager();

        /*try {
            teachers_and_departments.createNewFile();
        } catch (IOException ioException) {
            System.err.println(ioException);
        }*/

        System.out.println(databaseManager.deleteDatabaseIfExists(teachers_and_departments));
        
    }
}