
public class Solution {
    static Boolean valid(int num, String s) {

        // Convert the integer 'num' to a string.
        String curNumber = Integer.toString(num);
        int n = s.length();
        int len = curNumber.length();

        // Convert both strings 'curNumber' and 's' to length of three.
        while (len < 3) {
            curNumber = "0" + curNumber;
            len++;
        }
        while (n < 3) {
            s = "0" + s;
            n++;
        }

        // Check if the string is valid or not.
        for (int i = 0; i < 3; i++) {
            if (s.charAt(n - 3 + i) != curNumber.charAt(i) && s.charAt(n - 3 + i) != '#') {

                // If the 'curNumber' is invalid return false.
                return false;
            }
        }

        // The number is valid ,so return true.
        return true;
    }

    static int divisibleByEight(String s) {
        int n = s.length();

        // Initialize 'answer' to zero.
        long answer = 0;

        int num = 0;

        // Check all multiples of eight having less than or equal to three-digit.
        while (num < 1000) {

            // If 'num' is valid.
            if (valid(num, s)) {
                answer = answer + 1;
            }
            num = num + 8;
        }

        // For all digits after the last three-digit, if it is '#', we can try all ten possibilities.
        for (int i = n - 4; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                answer = (answer * (long)10) % 1000000007;
            }
        }

        // Return 'answer' here.
        return (int)answer;
    }
}
