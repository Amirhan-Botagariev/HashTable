import java.util.Random;

public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable<MyTestingClass, String>();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++){
            int value = rand.nextInt(0, 9999999);
            hashTable.put(new MyTestingClass(value), "Student " + value);
        }
        System.out.println(hashTable.getSize());
    }
}