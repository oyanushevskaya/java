package classes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class CustomerContainer {

    Customer addCustomer() {
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

    void sortCustomers(Customer[] customers) {
        Arrays.sort(customers, Comparator.comparing(Customer::getLastName));
        for (Customer customer: customers) {
            System.out.println(customer);
        }
        System.out.println("\n");
    }


    List<Customer> searchCardInInterval(Customer[] customers, long minNumberCreditCard, long maxNumberCreditCard) {
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer: customers) {
            if (customer.getNumberCreditCard() > minNumberCreditCard && customer.getNumberCreditCard() < maxNumberCreditCard) {
                customerList.add(customer);
            }
        }
        return customerList;
    }
}
