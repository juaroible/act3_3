package roig.juanmi;

import java.io.File;

public class DatabaseManager {
    
    /**
     * Calls deleteDirectory for deleting a File after finding out if that file exists, it can be a directory or a file.
     * @param database It's the File that contains the database to delete.
     * @return "Deleting database" when deletes the database (takes "true" from deleteDirectories),
     *         "Failed deleting database" when it can't delete the database (takes "false" from deleteDirectories),
     *         "Database doesn't exist" if database doesn't exist.
     */
    public String deleteDatabaseIfExists(File database) {

        String returnString = "";

        if (database.exists()) {
            if (deleteDirectories(database)) {
                returnString = "Deleting database";
            } else {
                returnString = "Failed deleting database";
            }
        } else {
            returnString = "Database doesn't exist";
        }

        return returnString;
    }

    /**
     * Deletes recursively the directory and his files.
     * @param databaseDirectory File to be deleted.
     * @return True after deleting the file, false if it can't be deleted.
     */
    public boolean deleteDirectories(File databaseDirectory) {
        if (databaseDirectory.exists()) {
            File[] files = databaseDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectories(databaseDirectory);
                    } else {
                        file.delete();
                    }
                }
            }
            return databaseDirectory.delete();
        } else {
            return false;
        }
    }

}
