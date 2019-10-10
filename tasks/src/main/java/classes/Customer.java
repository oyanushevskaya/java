package classes;

import java.math.BigInteger;

public class Customer implements Comparable<Customer> {
    private long customerId;
    private String firstName, middleName, lastName;
    private String address;
    private long numberCreditCard;
    private BigInteger numberBankAccount;

    public Customer() {
        super();
    }

    public Customer(long customerId, String lastName, String firstName, String middleName, String address, long numberCreditCard, BigInteger numberBankAccount) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.numberCreditCard = numberCreditCard;
        this.numberBankAccount = numberBankAccount;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setNumberCreditCard(long numberCreditCard) {
        this.numberCreditCard = numberCreditCard;
    }

    public long getNumberCreditCard() {
        return numberCreditCard;
    }

    public void setNumberBankAccount(BigInteger numberBankAccount) {
        this.numberBankAccount = numberBankAccount;
    }

    public BigInteger getNumberBankAccount() {
        return numberBankAccount;
    }

    @Override
    public int compareTo(Customer o) {
        return 0;
    }

    public int countCustomers(int customerId){
        return ++customerId;
    }

    @Override
    public String toString() {
        return customerId + ": " + lastName + " " + firstName + " " + middleName +
                "    Address: " + address + "    Credit card number:  " + numberCreditCard +
                "   Bank account number: " + getNumberBankAccount().toString();
    }


}
