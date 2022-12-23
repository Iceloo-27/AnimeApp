import App.Main;
import data.Anime;
import data.Permissions;
import data.User;
import database.DatabaseManager;
import database.MySqlManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, IOException {
        DatabaseManager databaseManager = MySqlManager.getInstance();
        User user = new User(1,"","", Permissions.ADMIN);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Список Аниме.txt"));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            if (line.isEmpty()){
                continue;
            }
            String d = bufferedReader.readLine();
            Anime anime = new Anime(0,line,d);
            databaseManager.addAnime(user,anime);
        }

    }
}
