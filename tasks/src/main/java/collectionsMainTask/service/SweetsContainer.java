package collectionsMainTask.service;

import collectionsMainTask.models.Sweets;

import java.util.List;

public class SweetsContainer {
    public static double totalPriceGift(List<Sweets> childrenGift) {
        double totalPriceGift = 0.0;
        for (Sweets s: childrenGift ) {
            totalPriceGift += s.getPrice();
        }
        return totalPriceGift;
    }

    public static void searchSweetForSugarConcentration(List<Sweets> childGift, int minSugarConcentration, int maxSugarConcentration) {
        for (Sweets sweets : childGift) {
            if (sweets.getSugarConcentration() >= minSugarConcentration && sweets.getSugarConcentration() <= maxSugarConcentration) {
                System.out.println(sweets);
            }
        }
    }

}
