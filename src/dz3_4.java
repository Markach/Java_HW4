import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
/*3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
  4.Отсортировать по возрасту используя дополнительный список индексов. */
public class dz3_4 {
    public static void main(String[] args) throws Exception {
        String file = "baza.sql";
        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        String personalData = "";
        FileReader reader = new FileReader(file);
        while (reader.ready()) {
            personalData +=(char)reader.read();
        }
        reader.close();

        String[] str = personalData.split("\n");
        for (int i = 0; i < str.length; i++) {
            String[] result = str[i].split(" ");
            family.add(result[0]+" ");
            name.add(result[1].charAt(0) + ".");
            soname.add(result[2].charAt(0) + ".");
            age.add(Integer.valueOf(result[3]));
            gender.add(result[4].equals("М") ? true : false);
            index.add(i);
        }
       
        int buf;
        int k = age.size();
        for(int i=0; i <k-1;i++){
            boolean sort = false;
            for (int j= 0; j < k-i-1; j++) {
                if((age.get(index.get(j)) > age.get(index.get(j+1)))){
                    buf=index.get(j);
                    index.set(j, index.get(j+1));
                    index.set(index.get(j+1), buf);
                    sort=true;  
                }
            }
            if(!sort) break;
        }
  
        for (int i = 0; i < index.size(); i++) {
            System.out.printf(family.get(index.get(i)));
            System.out.printf(name.get(index.get(i)));
            System.out.printf(soname.get(index.get(i)));
            System.out.printf(age.get(index.get(i)).toString());
            System.out.printf((gender.get(index.get(i)) ? " M" : " Ж"));
            System.out.println();
        }  
}}
