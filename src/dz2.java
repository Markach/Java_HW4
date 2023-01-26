import java.io.FileReader;
/*2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы.
 Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М" */
public class dz2 {
    public static void main(String[] args) throws Exception {
        String file = "baza.sql";
        readFile(file);

}

public static void readFile(String file)throws Exception{
    String personalData = "";
    FileReader reader = new FileReader(file);
    while (reader.ready()) {
        personalData +=(char)reader.read();
    }
    String [] string = personalData.split("\n");
    for (int i = 0; i < string.length; i++) {
        String [] tmp = string[i].split(" ");
        System.out.println(tmp[0]+ " " + tmp[1].charAt(0)+ "." + tmp[2].charAt(0)+"." +" "+ tmp[3]+" "+tmp[4]);
    }
    reader.close();
}
}