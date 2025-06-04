public class MyString {

    private String content;

    public MyString(String content){
        this.content = content;
    }

    private boolean isVowel(char a){
        char l = Character.toLowerCase(a);
        return l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u';
    }

    private boolean isConsonant(char a){
        return Character.isLetter(a) && !isVowel(a);
    }

    public int countVowels(){
        int sum = 0;

        for(int i = 0;i<content.length();i++){
            if(isVowel(content.charAt(i))){
                sum++;
            }
        }

        return sum;
    }

    public int countConsonants(){
    int sum = 0;

        for(int i = 0;i<content.length();i++){
            if(isConsonant(content.charAt(i))){
                sum++;
            }
        }

        return sum;
    }

    public int getLength(){
        return content.length();
    }

    public boolean isPalindrome(){

        int left = 0;
        int right = content.length() - 1;


        while(left < right){
            if(Character.toLowerCase(content.charAt(left)) != Character.toLowerCase(content.charAt(right))){
                return false;
            }

            left++;
            right--;
        }

        return true;

    }

    public String toString(){
        return "String: " + content + ", Length: " + getLength() + ", Vowels: " + countVowels() + ", Consonants: " + countConsonants() + ", Palindrome: " + isPalindrome() + ", Decimal: " + countDecimal();
    }

    public int countDecimal(){
        int sum = 0;

        for(int i = 0;i<content.length();i++){
            sum+=content.charAt(i);
        }
        return sum;
    }
    
}
