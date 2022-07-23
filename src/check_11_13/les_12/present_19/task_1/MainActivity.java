/*
� ����� ������� �� �� ���, �� ������ �������, �������� ���� Person, ���� �� ��� ���� : ��� �� ��.
���������� �� �� ��� � ����� � �ᒺ�� ���� Person.
��������� �ᒺ�� �������� � ����( toString() ).

 */

package check_11_13.les_12.present_19.task_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainActivity {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //������ � ������ � ��������;
       CharsToFile.createInputCharsFile();
       CharsToFile.fileReader(new File(Data.DIR_ROOT.data, Data.INPUT_FILENAME_CHARS.data));
       CharsToFile.fileWriterToString(new File(Data.DIR_ROOT.data, Data.OUTPUT_FILENAME_CHARS_toSTRING.data));
       CharsToFile.fileWriterToObject(new File(Data.DIR_ROOT.data, Data.OUTPUT_FILENAME_CHARS_totoOBJECT.data));
       CharsToFile.showPersonChar();

        //������ � ������ � ������;
       BytesToFile.createInputBytesFile();
       BytesToFile.fileReader(new File(Data.DIR_ROOT.data,Data.INPUT_FILENAME_BYTES.data));
       BytesToFile.fileWriterToString(new File(Data.DIR_ROOT.data, Data.OUTPUT_FILENAME_BYTES_toSTRING.data));
       BytesToFile.fileWriterToObject(new File(Data.DIR_ROOT.data, Data.OUTPUT_FILENAME_BYTES_toOBJECT.data));
       BytesToFile.showPersonBytes();

        // ������������ ������� (Externalizable);
        Serialize<Person> serialize = new Serialize<>();
        serialize.write(new Person("Serial", 25));
        System.out.println(serialize.read());
    }

    private static class Person implements Externalizable{

        private String name;
        private Integer age;

        public Person() {}

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.getName());
            out.writeObject(this.getAge());
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.name = (String) in.readObject();
            this.age = (Integer) in.readObject();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (!name.equals(person.name)) return false;
            return age.equals(person.age);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + age.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }


    }

    private static class FileCreator {

        static void createInputChars(String dir, String fileName, String...persons) throws IOException {
            File file  = new File(dir, fileName);
            if (file.createNewFile()) {
                Writer wr = new FileWriter(file);
                for (String person : persons) {
                    wr.write(person);
                    wr.write("\n");
                }
                wr.flush();
                wr.close();
            }
        }

        static void createInputBytes(String dir, String fileName, String...persons) throws IOException {

            File file  = new File(dir, fileName);
            if (file.createNewFile()) {
                FileOutputStream fos = new FileOutputStream(file);
                for (String person : persons) {
                    byte[] bs = (person + "\n").getBytes(Data.ENCODING.data);
                    fos.write(bs);
                }
                fos.flush();
                fos.close();
            }
        }
    }

    private static class CharsToFile {

        static final List<Person> people = new ArrayList<>();

        static void createInputCharsFile() throws IOException {
            FileCreator.createInputChars(Data.DIR_ROOT.data,Data.INPUT_FILENAME_CHARS.data,Data.ANDREW.data,Data.TOM.data);
        }

        static void fileReader(File input) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(input));
            String line;

            while ((line = br.readLine()) != null) {
                Person person = new Person();
                String[] substrings = line.split(" ");
                person.setName(substrings[0]);
                person.setAge(Integer.valueOf(substrings[1]));
                people.add(person);
            }
            br.close();
        }

        static void fileWriterToString(File output) throws IOException {
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            StringBuilder sb = new StringBuilder();
            people.forEach(person -> sb.append(person.toString()).append("\n"));
            try {
               bw.write(String.valueOf(sb));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            bw.flush();
            bw.close();
        }

        static void fileWriterToObject(File output) throws IOException {

        }

        static void showPersonChar() {
            System.out.println(people);
        }
    }

    private static class BytesToFile {

        static final List<Person> people = new ArrayList<>();

        static void createInputBytesFile() throws IOException {
            FileCreator.createInputBytes(Data.DIR_ROOT.data, Data.INPUT_FILENAME_BYTES.data, Data.ANDREW.data, Data.TOM.data);
        }

        static void fileReader(File inputFile) throws IOException {

            FileInputStream fis = new FileInputStream(inputFile);
            String[] persons = new String(fis.readAllBytes()).split("\n");

            for (String p : persons) {
                Person person = new Person();
                String[] substrings = p.split(" ");
                person.setName(substrings[0]);
                person.setAge(Integer.parseInt(substrings[1]));
                people.add(person);
            }
            fis.close();
        }

        static void fileWriterToString(File outputFile) throws IOException {
            FileOutputStream fos = new FileOutputStream(outputFile);
            StringBuilder sb = new StringBuilder();
            people.forEach(person -> sb.append(person.toString()).append("\n"));
            byte[] bytes = sb.toString().getBytes(Data.ENCODING.data);
            fos.write(bytes);
            fos.flush();
            fos.close();
        }

        static void fileWriterToObject(File output) throws IOException {

        }

        static void showPersonBytes() {
            System.out.println(people);
        }
    }

    private static class Serialize<T> {
        void write(T t) throws IOException {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(Data.DIR_ROOT.data, Data.SERIALIZE.data)));
            oos.writeObject(t);
            oos.flush();
            oos.close();
        }
        T read() throws IOException, ClassNotFoundException {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(Data.DIR_ROOT.data, Data.SERIALIZE.data)));
            T object = (T) ois.readObject();
            ois.close();
            return object;
        }
    }

    private enum Data {
        DIR_ROOT("D:\\WayToIT\\OOP\\src\\les_12\\present_19\\task_1"),
        INPUT_FILENAME_BYTES("INPUT_BYTES.txt"),
        INPUT_FILENAME_CHARS("INPUT_CHARS.txt"),
        OUTPUT_FILENAME_BYTES_toSTRING("OUTPUT_BYTES_toSTRING.txt"),
        OUTPUT_FILENAME_BYTES_toOBJECT("OUTPUT_BYTES_toOBJECT.txt"),
        OUTPUT_FILENAME_CHARS_toSTRING("OUTPUT_CHARS_toSTRING.txt"),
        OUTPUT_FILENAME_CHARS_totoOBJECT("OUTPUT_CHARS_totoOBJECT.txt"),
        SERIALIZE("SERIALIZABLE_OBJECT.txt"),
        ENCODING("UTF-8"),
        ANDREW("Andrew 21"),
        TOM("Tom 18");

        private final String data;

        Data(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }
}