import java.util.Comparator;

public class MyStringComparator implements Comparator<MyString>{

    @Override
    public int compare(MyString o1, MyString o2) {
        
        int length = o1.getLength() - o2.getLength();

        if(length != 0){
            return length;
        }

        int vowels = o1.countVowels() - o2.countVowels();

        if(vowels != 0){
            return vowels;
        }

        return o1.countDecimal() - o2.countDecimal();

    }

    
    
}
