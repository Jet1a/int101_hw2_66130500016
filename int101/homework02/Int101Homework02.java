package int101.homework02;

import work01Utilitor.Utilitor;
import work02Person.Person;
import work03Account.Account;

public class Int101Homework02 {

    public static void main(String[] args) {
        work01Utilitor();
        work02Person();
        work03Account();
    }

    static void work01Utilitor() {
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

        Utilitor utilitor = new Utilitor();

        System.out.println("--------------- 1.2-------------------" + '\n');

//        System.out.println(utilitor.testString());
//        System.out.println(utilitor.testString(""));
        System.out.println("Test String: " + utilitor.testString("Hello") + '\n');

        System.out.println("-------------- 1.3 ------------------" + '\n');

//        System.out.println(utilitor.testPositive(-1.0));
        System.out.println("Test Positive: " + utilitor.testPositive(50.0) + '\n');

        System.out.println("--------------- 1.4 -------------------" + '\n');

        System.out.println("Check Digits of 1000000000 ISBN-10: " + utilitor.computeIsbn10(100_000_000) + '\n');
        System.out.println("Check Digits of 1455338095 ISBN-10: " + utilitor.computeIsbn10(153_380_954) + '\n');
//        System.out.println("Valid of 1455338095 ISBN-10: " +utilitor.computeIsbn10(9_999_999_99));

    }

    static void work02Person() {
       /*
       2.1 Create a public class named "Person" in package named "work02Person".
           This class contains the following fields and methods.
       2.2 a private static field of type "int" named "nextId" initialized to 1.
       2.3 a private final field of type "int" named "id".
       2.4 a private field of type "String" named "firstname".
       2.5 a private field of type "String" named "lastname".
       2.6 a public constructor that receives "firstname" and "lastname"
           parameters to set the values of "firstname" and "lastname" fields.
           Check the correctness of the values of "firstname" and "lastname"
           parameters with "Utilitor.testString" method first.
           If nothing is wrong, set the value of "id" field to be the value
           of "nextId" field and increment the value of "nextId" by 1.
       2.7 @Override a public "toString" method that returns
           "Person(id,firstname,lastname)" where id, firstname, and lastname
           are the values of the coresponding fields of this "Person" object.
           Use "StringBuilder" to build the output string.
       2.8 public getters for "id", "firstname", and "lastname" fields.
       2.9 public setters for "firstname" and "lastname" fields.
           Use the "Utilitor.testString" method to check the correctness
           of the parameters first.
       2.10 @Override a public "equals" method that returns true
            if this object is the same as the object in the parameter
            (i.e., the same reference). Otherwise, it returns false.
       2.11 Show in this "work02Person" method how to use 2.6-2.10
            and check their correctness. */
        System.out.println("--------------- 2.6 / 2.7 -------------------" + '\n');

        Person person1 = new Person("Peter", "Parker");
        System.out.println(person1);
        Person person2 = new Person("Pecky", "Cather");
        System.out.println(person2 + "\n");

        System.out.println("--------------- 2.8 -------------------" + '\n');

        System.out.println("Person1 getFirstname: " + person1.getFirstname());
        System.out.println("Person2 getLastname: " + person2.getLastname() + "\n");

        System.out.println("--------------- 2.9 -------------------" + '\n');

        System.out.println("Before set: " + person2);
        person2.setFirstname("Peter");
        person2.setLastname("Parker");
        System.out.println("After set: " + person2 + "\n");

        System.out.println("--------------- 2.10 -------------------" + '\n');

        System.out.println("Person1 equals Person2: " + person1.equals(person2) + '\n'); //cause id != id

    }

    static void work03Account() {
       /*
       3.1 Create a public class named "Account" in package named "work03Account".
           This class contains the following fields and methods.
       3.2 a private static field of type "long" named "nextNo"
           initialized to 1_000_000_000.
       3.3 a private final "no" field of type "long".
       3.4 a private "owner" field of type "Person".
       3.5 a private "balance" field of type "double".
       3.6 a public constructor that receives an "owner" parameter of
           type "Person" to set the "owner" field. This method throws
           NullPointerException if the "owner" parameter is null.
           This method sets the value of "no" field to be the result from
           sending the "nextId" field to "Utilitor.computeIsbn10" method;
           and then increments the value of "nextId" by 10.
           This method sets the value of "balance" to 0.0.
       3.7 public getters for "no", "owner", and "balance".
       3.8 a public method named "deposit" that receives a "double" parameter
           named "amount". This method throws IllegalArgumentException
           if "amount" cannot pass "Utilitor.testPositive" method.
           Otherwise, the method adds the "amount" to "balance"
           and then returns the new "balance".
       3.9 a public method named "withdraw" that receives a "double" parameter
           named "amount". This method throws IllegalArgumentException
           if "amount" does not pass "Utilitor.testPositive" method.
           Otherwise, the method subtracts the "amount" from "balance"
           and then returns the new "balance".  However, this method will not
           do so if the new "balance" cannot pass "Utilitor.testPositive" method.
       3.10 a public method named "transfer" that recieves a "double" parameter
            named "amount" and an "Account" parameter named "account".
            This method throws IllegalArgumentException if "account" is null
            or it cannot "withdraw" the "amount" from this object. Otherwise,
            this method "withdraw" the "amount" from this object and "deposit"
            the "amount" to the "account" object.  This method returns nothing.
       3.11 @Override a public "toString" method that returns
            "Account(no,balance)" where "no" and "balance" are
            the "no" and "balance" fields of this object.
       3.12 @Override a public "equals" method that returns true
            if this object is the same as the object in the parameter
            (i.e., the same reference). Otherwise, it returns false.
       3.13 Show in this "work03Account" method how to use 3.6-3.12
            and check their correctness. */
        System.out.println("--------------- 3.6 -------------------" + '\n');
        Person personA = new Person("Andy","Carol");
        Person personB = new Person("Carlos", "Puyol");
        Account account1 = new Account(personA);
        Account account2 = new Account(personB);
        System.out.println(account1);
        System.out.println(account2 + "\n");
        System.out.println("--------------- 3.7 -------------------" + '\n');

        System.out.println(account1.getOwner() + "\n");

        System.out.println("--------------- 3.8 -------------------" + '\n');

        System.out.println("Deposit 10000$: " + account1.deposit(10000.00));
        System.out.println("Account 1 balance: " + account1.getBalance()  + '\n');

        System.out.println("--------------- 3.9 -------------------" + '\n');

        System.out.println("Withdraw 2500$: " + account1.withdraw(2500.00));
        System.out.println("Account 1 balance: " + account1.getBalance() + '\n');

        System.out.println("--------------- 3.10 -------------------" + '\n');
        System.out.println("Before | Account1 balance: " + account1.getBalance() + " , Account2 balance: " + account2.getBalance());
        account1.transfer(5000.00,account2);
        System.out.println("Transfer 5000$ account1 -> account2");
        System.out.println("After | Account1 balance: " + account1.getBalance() + " , Account2 balance: " + account2.getBalance() + "\n");

        System.out.println("--------------- 3.11 / 3.12 -------------------" + '\n');

        System.out.println(account1);
        System.out.println(account2);
        System.out.println("Equals: " + account1.equals(account2));
    }
}
