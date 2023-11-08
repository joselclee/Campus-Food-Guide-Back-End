package CampusFoodGuide.searching;
import CampusFoodGuide.Food.FoodItem.Food;
import java.util.List;

public class searchByCalories {
    public static Food calSearch(List<Food> items, int targetCal) {
        int low = 0;
        int high = items.size() - 1;

        while (low <= high && targetCal >= items.get(low).getCalories() && targetCal <= items.get(high).getCalories()) {
            if (low == high) {
                if (items.get(low).getCalories() == targetCal) {
                    return items.get(low);
                }
                return null;
            }

            int interpolation = low + (((targetCal - items.get(low).getCalories()) * (high - low)) /
                    (items.get(high).getCalories() - items.get(low).getCalories()));

            int pos = (int) interpolation;

            if (items.get(pos).getCalories() == targetCal) {
                return items.get(pos);
            } else if (items.get(pos).getCalories() < targetCal) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return null;
    }
}