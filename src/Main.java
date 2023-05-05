import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, IncorrectInputException {
        Scanner sc = new Scanner(System.in);


        System.out.println("Выберите тип перевода: ru/en - 1, en/ru - 2");
        int k = sc.nextInt();
        System.out.println("Введите слово: ");
        String s = sc.next();

        switch (k){
            case 1:
                ResultSet rs = GetFromDb.getRuToEnTranslation(s);
                while(rs.next()){
                    System.out.println(rs.getString("en_word"));
                }
                break;
            case 2:
                rs = GetFromDb.getEnToRuTranslation(s);
                while(rs.next()){
                    System.out.println(rs.getString("ru_word"));
                }
                break;
            default:
                throw new IncorrectInputException("Incorrect input for menu: " + k);
        }

    }
}