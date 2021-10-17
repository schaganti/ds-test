package chags.io.ds.hackerrank;

public class StrongPassword {

    public static int minimumNumber(int n, String password) {

        String numbers = "0123456789";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-+";

        int totlaCharsRequired = 6 - password.length();
        char[] paswordChars = password.toCharArray();

        boolean specialCharFound = false;
        boolean numberFound = false;
        boolean lowerCaseFound = false;
        boolean upperCaseFound = false;

        for(int i=0; i<paswordChars.length; i++) {
            if(!numberFound && found(numbers, paswordChars[i])) {
                numberFound = true;
            }
            if(!specialCharFound && found(specialCharacters, paswordChars[i])) {
                specialCharFound = true;
            }
            if(!lowerCaseFound && found(lowerCase, paswordChars[i])) {
                lowerCaseFound = true;
            }
            if(!upperCaseFound && found(upperCase, paswordChars[i])) {
                upperCaseFound = true;
            }
        }
        int missMatchCount = numberFound == true ? 0 : 1;
        missMatchCount += lowerCaseFound == true ? 0 : 1;
        missMatchCount += upperCaseFound == true ? 0 : 1;
        missMatchCount += specialCharFound == true ? 0 : 1;
        if(totlaCharsRequired >= missMatchCount) {
            return totlaCharsRequired;
        } else {
            return missMatchCount;
        }
        // Return the minimum number of characters to make the password strong

    }

    public static boolean found(String sequence, char ch) {
        return sequence.indexOf(ch) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(StrongPassword.minimumNumber(1, "Ab1"));
    }

}
