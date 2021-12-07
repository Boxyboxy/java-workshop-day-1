package workshopd1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Hello world!
 *
 */
public class ShoppingCartDB {
    private File directory;
    private File userDatabase;
    private boolean login = false;

    // constructors
    public ShoppingCartDB() {
        this.directory = Path.of("db").toFile();
        if (!this.directory.exists()) {
            this.directory.mkdir();
        }
    }

    public ShoppingCartDB(String CartDB) {
        this.directory = Path.of(CartDB).toFile();
        if (!this.directory.exists()) {
            this.directory.mkdir();
        }
    }

    // getter to use boolean in Main script
    public boolean getLogin() {
        return this.login;
    }

    public void login(String username, ArrayList<String> userList) {
        // create path for database
        String userPath = this.directory.getAbsolutePath() + "/" + username + ".db";
        // create database reference
        this.userDatabase = Path.of(userPath).toFile();

        if (!this.userDatabase.exists()) { // if database does not exist
            try {
                this.userDatabase.createNewFile(); // create database
                System.out.println("User absent. File created: " + this.userDatabase.getName());

            } catch (IOException e) {
                System.out.println("An error occurred.");
                System.err.println(e);
            }
        } else {
            System.out.println("User found. Login successful."); // else, inform user that login is successful
        }

        this.load(username, userList);
    }

    // load function that is a helper function used in login
    public void load(String username, ArrayList<String> userList) {
        // loading user cart from database
        String item;

        if (this.login) { // if already logged in, clear cart before loading cart with database items
            userList.clear();
        }
        // buffered reader
        try {
            // initialise buffered reader
            BufferedReader reader = Files.newBufferedReader(this.userDatabase.toPath());
            while ((item = reader.readLine()) != null) {
                userList.add(item);
            }
            reader.close();

        } catch (IOException e) {
            System.err.println(e);
        }
        this.login = true;
    }

    // save method to write data into database
    public void save(ArrayList<String> userList) {
        // buffered writer
        if (this.userDatabase == null) {
            System.out.println("No login detected. please login using 'login <username>'");
            return;
        }
        try {
            BufferedWriter writer = Files.newBufferedWriter(this.userDatabase.toPath());
            writer.flush();
            // writer.write(this.directory.getName() + '/' + this.userDatabase.getName());
            // writer.newLine();
            for (String item : userList) {
                writer.write(item);
                writer.newLine();
            }
            writer.close();
            System.out.println("Cart saved into database");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    protected void users() {
        for (File user : this.directory.listFiles()) {
            System.out.println(user.getName());
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
