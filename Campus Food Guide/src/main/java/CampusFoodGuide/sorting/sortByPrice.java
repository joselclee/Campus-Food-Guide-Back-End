package CampusFoodGuide.sorting;

import java.util.ArrayList;
import CampusFoodGuide.Food.FoodItem.Food;

public class sortByPrice {

    public static void priceSort(ArrayList<Food> foodList) {
        if (foodList == null || foodList.size() <= 1) {
            return; // Nothing to sort
        }

        int middle = foodList.size() / 2;
        ArrayList<Food> left = new ArrayList<>(foodList.subList(0, middle));
        ArrayList<Food> right = new ArrayList<>(foodList.subList(middle, foodList.size()));

        priceSort(left);
        priceSort(right);

        merge(foodList, left, right);
    }

    // Merge helper function - can be reused as long as you change the key
    private static void merge(ArrayList<Food> result, ArrayList<Food> left, ArrayList<Food> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getPrice() <= right.get(j).getPrice()) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }
}