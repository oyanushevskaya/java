package classes;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class CustomerContainer {

    public Customer customerAdd() {
        Customer customer = new Customer();
        customer.setCustomerId(6);
        customer.setLastName("Harris");
        customer.setFirstName("Edward");
        customer.setMiddleName("Brian");
        customer.setAddress("Belfast");
        customer.setNumberCreditCard(4985_9856_3214_9898L);
        customer.setNumberBankAccount(new BigInteger("40005236987741254896"));
        return new Customer(customer.getCustomerId(), customer.getLastName(), customer.getFirstName(), customer.getMiddleName(),
                customer.getAddress(), customer.getNumberCreditCard(), customer.getNumberBankAccount());
    }

    public void getAllCustomers(Customer[] customers) {
        for (Customer customer: customers) {
            System.out.println(customer);
        }
        System.out.println("\n");
    }
    public void sortCustomers(Customer[] customers) {
        Arrays.sort(customers, Comparator.comparing(Customer::getLastName));
        for (Customer customer: customers) {
            System.out.println(customer);
        }
        System.out.println("\n");
    }


    public void searchCardInInterval(Customer[] customers, long MIN_VALUE, long MAX_VALUE) {
        for (Customer customer: customers) {
            if (customer.getNumberCreditCard() > MIN_VALUE && customer.getNumberCreditCard() < MAX_VALUE) {
                System.out.println(customer);
            }
        }
    }
}
