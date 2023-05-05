import java.sql.ResultSet;
import java.sql.SQLException;

public class GetFromDb extends MySQLConnect{

    public static ResultSet getAll(){
        String query = "SELECT * FROM en_ru e left join ru_en r on e.id=r.id";
        return executeQuery(query);
    }

    public static ResultSet getRuToEnTranslation(String s){
        String query = "SELECT en_word from ru_en where ru_word = \"" + s + "\"";
        return executeQuery(query);
    }
    public static ResultSet getEnToRuTranslation(String s){
        String query = "SELECT ru_word FROM en_ru where en_word = \"" + s + "\"";
        return executeQuery(query);
    }
    private static ResultSet executeQuery(String query) {
        try {
            return getConnection()
                    .createStatement()
                    .executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
