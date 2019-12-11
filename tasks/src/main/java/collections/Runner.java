package collections;

import collections.models.Biscuits;
import collections.models.Candy;
import collections.models.Chocolate;
import collections.models.Sweets;
import collections.service.SweetsContainer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        final int MIN_SUGAR_CONCENTRATION = 5;
        final int MAX_SUGAR_CONCENTRATION = 100;
        Sweets chocolate = new Chocolate("Alpen Gold", 2.5, 200, 150, Chocolate.ChocolateType.MILK);
        Sweets candy = new Candy("Rondo", 1.5, 100, 50, Candy.CandyType.CARAMEL);
        Sweets biscuits = new Biscuits("Oreo", 4, 200, 20, Biscuits.BiscuitsType.DROP);

        List<Sweets> childGift = new ArrayList<Sweets>();
        childGift.add(chocolate);
        childGift.add(candy);
        childGift.add(biscuits);
        childGift.forEach(System.out::println);

        System.out.println("\nTotal price of gift : " + SweetsContainer.totalPriceGift(childGift));

        System.out.println("\nSorted sweets:");
        childGift.sort(Comparator.comparing(Sweets::getPrice).reversed());
        for (Sweets sweets: childGift) {
            System.out.println(sweets);
        }
        System.out.println("\n");

        List<Sweets> chosenSweets = SweetsContainer.searchSweetForSugarConcentration(childGift, MIN_SUGAR_CONCENTRATION, MAX_SUGAR_CONCENTRATION);
        chosenSweets.forEach(System.out::println);
    }
}
