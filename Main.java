import java.util.Arrays;

public class Main{

    public static void main(String[] args){
        MyString[] strings = {
            new MyString("Otto"),
            new MyString("Apple"),
            new MyString("Racecar"),
            new MyString("Banana"),
            new MyString("Eagle"),
            new MyString("Zebra"),
            new MyString("Kayak")
        };

        System.out.println("Unsorted:");
        for (MyString s : strings) {
            System.out.println(s);
        }

        Arrays.sort(strings, new MyStringComparator());

        System.out.println("\nSorted:");
        for (MyString s : strings) {
            System.out.println(s);
        }
    }


}