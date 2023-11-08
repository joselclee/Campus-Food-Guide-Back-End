package CampusFoodGuide.sorting;

import java.util.ArrayList;
import CampusFoodGuide.Food.FoodItem.Food;

public class sortByType {
    
    private static void merge(ArrayList<Food> result, ArrayList<Food> left, ArrayList<Food> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getCategory().compareTo(right.get(j).getCategory()) <= 0) {
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

    public static void typeSort(ArrayList<Food> foodList) {
        if (foodList == null || foodList.size() <= 1) {
            return;
        }
        
        int mid = foodList.size()/2;
        ArrayList<Food> left = new ArrayList<>(foodList.subList(0, mid));
        ArrayList<Food> right = new ArrayList<>(foodList.subList(mid, foodList.size()));

        typeSort(left);
        typeSort(right);

        merge(foodList, left, right);
    }
}
