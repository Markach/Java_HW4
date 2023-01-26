import java.io.FileReader;
import java.io.FileWriter;
/*1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader */
public class dz1 {
    public static void main(String[] args) throws Exception {
        String file = "baza.sql";
        FileWriter writer = new FileWriter(file, true);
        writeFile(writer);
        readFile(file);
    }
        public static void writeFile(FileWriter writer)throws Exception{
            writer.append("Иванов Иван Иванович 32 М\n");
            writer.append("Иванова Ольга Ивановна 23 Ж\n");
            writer.append("Смирнов Алексей Романович 45 М\n");
            writer.append("Яковлев Роман Валентинович 67 М\n");
            writer.append("Круглова Анна Семеновна 55 Ж");
            writer.flush();
        }

        public static void readFile(String file)throws Exception{
            String personalData = "";
            FileReader reader = new FileReader(file);
            while (reader.ready()) {
                personalData +=(char)reader.read();
            }
            System.out.println(personalData);
            reader.close();
    }
}


