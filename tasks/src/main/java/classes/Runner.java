package classes;

import java.math.BigInteger;

public class Runner {
    public static void main(String[] args) {
        final long MIN_NUMBER_CREDIT_CARD = 2000_0000_0000_0000L;
        final long MAX_NUMBER_CREDIT_CARD = 9999_9999_9999_9999L;
        CustomerContainer container = new CustomerContainer();
        Customer[] customers= {
                new Customer(1,"Mills", "Steven", "Vincent", "London",
                        1000_000_000_000L, new BigInteger("40817810099910004312")),
                new Customer(2,"Andrews", "Betty", "Lane", "Chester",
                        2888_8888_9999_0000L,new BigInteger("40817810099910004313")),
                new Customer(3, "Benson", "Mary", "Elizabeth", "Glasgow",
                        3456_9523_8523_1253L, new BigInteger("40817810099910004314")),
                new Customer(4, "Wade", "Anthony", "Ellison", "Manchester",
                        4567_5963_7896_3569L, new BigInteger("40817810099910004315")),
                new Customer(5, "Lawson", "Gregory", "Julian", "Newport",
                        9999_9999_9999_9999L, new BigInteger("40817810099910004316")),
                container.customerAdd()
        };

        container.getAllCustomers(customers);
        container.sortCustomers(customers);
        container.searchCardInInterval(customers, MIN_NUMBER_CREDIT_CARD, MAX_NUMBER_CREDIT_CARD);
    }
}
