public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int check = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                check++;
            }
            if (str.charAt(i) == '(') {
                check--;
            }
        }
        return check == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int i) {
        String test = "";
        for (int x = 0; x < Integer.toString(i).length(); x++) {
            test = Integer.toString(i).charAt(x) + test;
        }
        return (test);
    }


    // 3. encryptThis
    private static String encryptWord(String word) {
        if (word.isEmpty()) {
            return "";
        }

        int length = word.length();
        int firstCharCode = word.charAt(0);

        if (length == 1) {
            return String.valueOf(firstCharCode);
        }

        char[] characters = word.toCharArray();
        char secondLetter = characters[1];
        characters[1] = characters[length - 1];
        characters[length - 1] = secondLetter;

        return firstCharCode + new String(characters, 1, length - 1);
    }

    public static String encryptThis(String a) {
        StringBuilder result = new StringBuilder();
        // Split the input string into words
        String[] listofwords = a.split(" ");

        for (String word : listofwords) {
            result.append(encryptWord(word)).append(" ");
        }

        // Trim any leading or trailing spaces and return the result
        return result.toString().trim();
    }
    private static String decipherWord(String word) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        char z = 'e';
            while(Character.isDigit(word.charAt(i))){
                i++;
            }
        char decodedChar = (char) Integer.parseInt(word.substring(0, i));  // this is the number turned into word
            char second = word.charAt(word.length()-1);

            z = word.charAt(i);
            str.append(z);
            if(word.length()-1 == i){
                str.append(decodedChar);
                str.append(str.charAt(str.indexOf(String.valueOf(z))));
                str.deleteCharAt(0);
            } else if (word.length()-i == 1) {
                str.append(decodedChar);
                str.append(str.charAt(str.indexOf(String.valueOf(z))));

                str.deleteCharAt(0);
            } else{
                str.append(decodedChar).append(second).append(word.substring(i+1,word.length()-1));
                str.append(str.charAt(str.indexOf(String.valueOf(z))));
                str.deleteCharAt(0);
            }


            return str.toString();
    }

    // 4. decipherThis
    public static String decipherThis(String a) {
        StringBuilder result = new StringBuilder();
        // Split the input string into words
        String[] listofwords = a.split(" ");
        String phrase = "";
        for (int i = 0; i < listofwords.length-1; i++) {
            result.append(decipherWord(listofwords[i]));
                result.append(" ");
        }
        phrase = result.toString() + decipherWord(listofwords[2]);
        // Trim any leading or trailing spaces and return the result
        return phrase.trim();
    }
// this took way too long

}