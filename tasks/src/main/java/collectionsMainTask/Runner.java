package collectionsMainTask;

import collectionsMainTask.models.Biscuits;
import collectionsMainTask.models.Candy;
import collectionsMainTask.models.Candy.CandyType;
import collectionsMainTask.models.Chocolate;
import collectionsMainTask.models.Chocolate.ChocolateType;
import collectionsMainTask.models.Sweets;
import collectionsMainTask.service.SweetsContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static collectionsMainTask.models.Biscuits.*;

public class Runner {
    public static void main(String[] args) {
        Sweets chocolate = new Chocolate("Alpen Gold", 2.5, 200, 150, ChocolateType.MILK);
        Sweets candy = new Candy("Rondo", 1.5, 100, 50, CandyType.CARAMEL);
        Sweets biscuits = new Biscuits("Oreo", 4, 200, 20, BiscuitsType.DROP);

        List<Sweets> childGift = new ArrayList<Sweets>();
        childGift.add(chocolate);
        childGift.add(candy);
        childGift.add(biscuits);

        System.out.println(SweetsContainer.totalPriceGift(childGift));

        Collections.sort(childGift, Comparator.comparing(Sweets::getPrice).reversed());
        for (Sweets s: childGift) {
            System.out.println(s);
        }

        System.out.println("\n");

        SweetsContainer.searchSweetForSugarConcentration(childGift, 5, 100);
    }
}
