package work01Utilitor;

public class Utilitor {
    /*
       1.1 Create a public utility class named "Utilitor" in package named "work01Utilitor".
       1.2 Create a public method named "testString" in "Utilitor" class.
           This method receives a parameter of type "String"
           named "value" and it returns the "value" if nothing is wrong.
           However, if the "value" is null, it throws NullPointerException.
           If the "value" is a blank string, it throws IllegalArgumentException.
       1.3 Create a public method named "testPositive" in "Utilitor" class.
           This method receives a parameter of type "double" named "value"
           and it returns the "value" if this "value" is a positive value.
           Otherwise, it throws IllegalArgumentException.
       1.4 Create a public method named "computeIsbn10" in "Utilitor" class.
           This method recieves a parameter of type "long" named "isbn10"
           and it returns the value of "isbn10" whose last digit is modified
           to make it a valid ISBN-10.
           See https://en.wikipedia.org/wiki/Check_digit for ISBN-10 calculation.
           ** You must use loop to calculate the ISBN-10 check-digit. **
       1.5 Show in this "work01Utilitor" method how to use 1.2-1.4 and
           check their correctness. */
    public String testString(String value) {
        if (value == null) throw new NullPointerException("The value is null");
        if (value.isBlank()) throw new IllegalArgumentException("The value is blank string");
        return value;
    }

    public static double testPositive(double value) {
        if (value < 0) throw new IllegalArgumentException("The value is negative");
        return value;
    }

    public long computeIsbn10(long isbn10) {

        if (String.valueOf(isbn10).length() != 9) {
            throw new IllegalArgumentException("ISBN-10 should be a 10-digit number.");
        }

        String stringIsbn = String.valueOf(isbn10);
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(stringIsbn.charAt(i));
            sum += (i + 1) * digit;
        }

        int remain = sum % 11;

        return (remain == 0) ? 0 : 11 - remain;

    }
}
