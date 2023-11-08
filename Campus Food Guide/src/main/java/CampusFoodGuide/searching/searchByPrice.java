package CampusFoodGuide.searching;
import CampusFoodGuide.Food.FoodItem.Food;
import java.util.List;

public class searchByPrice {
    public static Food priceSearch(List<Food> items, double targetPrice) {
        int low = 0;
        int high = items.size() - 1;

        while (low <= high && targetPrice >= items.get(low).getPrice() && targetPrice <= items.get(high).getPrice()) {
            if (low == high) {
                if (items.get(low).getPrice() == targetPrice) {
                    return items.get(low);
                }
                return null;
            }

            double interpolation = low + (((targetPrice - items.get(low).getPrice()) * (high - low)) /
                    (items.get(high).getPrice() - items.get(low).getPrice()));

            int pos = (int) interpolation;

            if (items.get(pos).getPrice() == targetPrice) {
                return items.get(pos);
            } else if (items.get(pos).getPrice() < targetPrice) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return null;
    }
}
