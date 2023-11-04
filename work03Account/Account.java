package work03Account;

import work01Utilitor.Utilitor;

import work02Person.Person;

import java.time.Year;
import java.util.Objects;

public class Account {
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
    private static long nextNo = 100_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) throw new NullPointerException("Owner can't be null");
        Utilitor utilitor = new Utilitor();
        while (true) {
            long result = utilitor.computeIsbn10(nextNo);
            while (result == 10) {
                nextNo++;
                result = utilitor.computeIsbn10(nextNo);
            }
            this.no = 10 * nextNo + result;
            nextNo++;
            break;
        }
        this.owner = owner;

        this.balance = 0.0;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        Utilitor.testPositive(amount);
        return this.balance += amount;
    }

    public double withdraw(double amount) {
        Utilitor.testPositive(amount);
        this.balance -= amount;
        Utilitor.testPositive(balance);
        return balance;
    }

    //    3.10 a public method named "transfer" that recieves a "double" parameter
//            named "amount" and an "Account" parameter named "account".
//            This method throws IllegalArgumentException if "account" is null
//            or it cannot "withdraw" the "amount" from this object. Otherwise,
//            this method "withdraw" the "amount" from this object and "deposit"
//            the "amount" to the "account" object.  This method returns nothing.
    public void transfer(double amount, Account account) {
        if (account == null) throw new IllegalArgumentException("Account cannot be null");
        withdraw(amount);
        account.deposit(amount);
    }
//     3.11 @Override a public "toString" method that returns
//            "Account(no,balance)" where "no" and "balance" are
//            the "no" and "balance" fields of this object.

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("no=").append(no);
        sb.append(", owner=").append(owner);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return no == account.no && Double.compare(balance, account.balance) == 0 && Objects.equals(owner, account.owner);
    }


}
