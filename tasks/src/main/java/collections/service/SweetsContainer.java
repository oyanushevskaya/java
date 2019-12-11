package collections.service;

import collections.models.Sweets;

import java.util.ArrayList;
import java.util.List;

public class SweetsContainer {
    public static double totalPriceGift(List<Sweets> childrenGift) {
        double totalPriceGift = 0.0;
        for (Sweets s: childrenGift ) {
            totalPriceGift += s.getPrice();
        }
        return totalPriceGift;
    }

    public static List<Sweets> searchSweetForSugarConcentration(List<Sweets> childGift, int minSugarConcentration, int maxSugarConcentration) {
        List<Sweets> sweetsList = new ArrayList<>();
        for (Sweets sweets : childGift)
            if (sweets.getSugarConcentration() >= minSugarConcentration && sweets.getSugarConcentration() <= maxSugarConcentration) {
                sweetsList.add(sweets);
            }
        return sweetsList;
    }
}
