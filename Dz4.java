
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Dz4 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> fam = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> ser = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gen = new ArrayList<>();

        LinkedList<Integer> index = new LinkedList<>();
        String text = "";
        try {
            // FileWriter writer = new FileWriter("db.sql",true);
            // writer.append("Иванов Иван Иванович 32 М ");
            // writer.flush();

            FileReader reader = new FileReader("db.sql");
            while (reader.ready()) {
                text += (char) reader.read();
            }
        } catch (IOException e) {
            ;
            throw new RuntimeException(e);
        }
        String[] str = text.split("\r\n");
        for (int i = 0; i < str.length; i++) {
            String[] strB = str[i].split(" ");
            fam.add(strB[0]);
            name.add(String.valueOf(strB[1].charAt(0)));
            ser.add(String.valueOf(strB[2].charAt(0)));
            age.add(Integer.valueOf(strB[3]));
            gen.add(strB[4].equals("Ж") ? true : false);
            index.add(i);

        }

            for (int j = 0; j < index.size(); j++) {
                for (int k = 0; k < index.size(); k++) {
                    if (age.get(index.get(j)) > age.get(index.get(k))) {
                        int tmp = index.get(k);
                        index.set(k, index.get(j));
                        index.set(j, tmp);

                    }
                }
            }



        for (int x = 0; x < index.size(); x++) {

            System.out.printf(fam.get(index.get(x)) + " ");
            System.out.printf(name.get(index.get(x)) + ". ");
            System.out.printf(ser.get(index.get(x)) + ". ");
            System.out.printf(age.get(index.get(x)).toString() + " ");
            System.out.printf((gen.get(index.get(x)) ? " Ж" : " М"));
            System.out.println();

        }

    }

}