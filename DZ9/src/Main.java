import javax.imageio.stream.ImageInputStream;

public class Main {
    public static void main(String[] args) {
        String s = "Hello world!";
        String st_1 = "racecar";
        String s_2 = "abcd1234567890efg";

        if (task1(st_1)) {
            System.out.println("Task 1: " + st_1 + " is palindrome");
        } else {
            System.out.println("Task 1: " + st_1 + " is NOT palindrome");
        }
        if (task1(s)) {
            System.out.println("Task 1: " + s + " is palindrome");
        } else {
            System.out.println("Task 1: " + s + " is NOT palindrome");
        }

        int count2 = task2(s);
        System.out.println("Task 2: In string " + s + " are " + count2 + " vowels");

        task3(s);
        System.out.println("Task 3: " + task3(s));

        task4("");
        task4("    ");
        task4(s);

        task5(s);

        task6("abracadabra ", 3);

        task7(s, "X");
        task7("abracadabra", "a");

        task8(s);

        task9(s);

        task10(s_2);

        boolean isAnagram1 = task11("Listen", "Silent");
        boolean isAnagram2 = task11("Hello", "World");


        System.out.println("Task 12: " + task12("aaabcc"));
        System.out.println("Task 12: " + task12("abcdefg"));

        System.out.println("Task 13: " + task13("hello", "yellow"));

    }

    public static boolean task1(String str) {
        boolean res = false;
        int end1 = str.length() / 2;
        int start2 = str.length() - end1;
        String str1 = str.substring(0, end1);
        String str2 = str.substring(start2, str.length());
        if (str1.equals(task3(str2))) {
            res = true;
        }
        return res;
    }

    public static int task2(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u')) {
                count++;
            }
        }
        return count;
    }

    public static String task3(String s) {
        String text = "";
        for (int i = 0; i < s.length(); i++) {
            text += s.charAt(s.length() - 1 - i);
        }
        return text;
    }

    public static boolean task4(String str) {
        boolean isEmpty = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                isEmpty = false;
            }
        }

        if (str.length() == 0) {
            isEmpty = true;
        }
        System.out.println("Task 4: \"" + str + "\" is empty = " + isEmpty);
        return isEmpty;
    }

    public static int task5(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isLetter(ch)) {
                count++;
            }
        }
        System.out.println("Task 5: \"" + str + "\" have " + count + " letters");
        return count;
    }

    public static String task6(String str, int count) {
        String res = "";
        res = str.repeat(count);
        System.out.println("Task 6: \"" + str + "\"  " + count + " times: " + res);
        return res;
    }

    public static Boolean task7(String str, String ch) {
        Boolean res = true;
        if (!str.startsWith(ch)) {
            res = false;
        }
        if (!str.endsWith(ch)) {
            res = false;
        }

        System.out.println("Task 7: \"" + str + "\"  starts and ends a char character \"" + ch + "\" is " + res);
        return res;
    }

    public static String task8(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                res += str.charAt(i);
            }
        }

        System.out.println("Task 8: " + str + "  " + res);
        return res;
    }

    public static String task9(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            res += String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(i));
        }
        System.out.println("Task 9: " + str + "  " + res);
        return res;
    }

    public static String task10(String str) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (isDigit(str.charAt(i))) {
                res += "*";
            } else {
                res += str.charAt(i);
            }
        }

        System.out.println("Task 10: " + str + "  " + res);
        return res;
    }

    public static boolean task11(String str_1, String str_2) {
        boolean res = true;

        for (int i = 0; i < str_1.length(); i++) {
            boolean isFound = false;
            for (int j = 0; j < str_2.length(); j++) {
                if (String.valueOf(str_2.charAt(j)).equalsIgnoreCase(String.valueOf(str_1.charAt(i)))) {
                    isFound = true;
                    break;
                }
                ;
            }
            if (!isFound) {
                res = false;
                break;
            }
        }

        for (int i = 0; i < str_2.length(); i++) {
            boolean isFound = false;
            for (int j = 0; j < str_1.length(); j++) {
                if (String.valueOf(str_1.charAt(j)).equalsIgnoreCase(String.valueOf(str_2.charAt(i)))) {
                    isFound = true;
                    break;
                }
                ;
            }
            if (!isFound) {
                res = false;
                break;
            }
        }

        if (res) {
            System.out.println("Task 11: String \"" + str_1 + "\" and  string \"" + str_2 + "\" are anagrams");
        } else {
            System.out.println("Task 11: String \"" + str_1 + "\" and  string \"" + str_2 + "\" are NOT anagrams");
        }
        return res;
    }

    public static String task12(String str) {
        String res = "";
        boolean origin = true;
        char lastChar = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == lastChar) {
                count++;
                origin = false;
            } else {
                res += String.valueOf(lastChar) + count;
                lastChar = str.charAt(i);
                count = 1;
            }
        }
        res += String.valueOf(lastChar) + count;
        if (origin) {
            return str;
        } else {
            return res;
        }
    }

    public static String task13(String str_1, String str_2) {  // "hello", "yellow"
        String res = "";
        for (int i = 0; i < str_1.length(); i++) {
            for (int j = i + 2; j <= str_1.length(); j++) {
                if (str_2.contains(str_1.subSequence(i, j))){
                    if(str_1.subSequence(i, j).length() > res.length()) {
                        res = String.valueOf(str_1.subSequence(i, j));
                    }
                }
            }
        }

        return res;
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }

    private static boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }
}
