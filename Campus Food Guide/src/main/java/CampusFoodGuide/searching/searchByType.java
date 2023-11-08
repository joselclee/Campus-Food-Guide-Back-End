package searching;
import Food.FoodItem.Food;
import java.util.List; 

public class searchByType {
    public static Food typeSearch(List<Food> items, String searchCategory) {
        int low = 0;
        int high = items.size() - 1;
        
        while (low <= high && searchCategory.compareTo(items.get(low).getCategory()) >= 0 && searchCategory.compareTo(items.get(high).getCategory()) <= 0) {
            if (low == high) {
                if (items.get(low).getCategory().equals(searchCategory)) {
                    return items.get(low);
                }
                return null;
            }
            
            if (items.get(high).getCategory().equals(items.get(low).getCategory())) {
                if (items.get(low).getCategory().equals(searchCategory)) {
                    return items.get(low);
                }
                return null;
            }
            
            int pos = low + ((searchCategory.compareTo(items.get(low).getCategory()) * (high - low)) /
                    items.get(high).getCategory().compareTo(items.get(low).getCategory()));
            
            if (items.get(pos).getCategory().equals(searchCategory)) {
                return items.get(pos);
            } else if (items.get(pos).getCategory().compareTo(searchCategory) < 0) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return null;
    }
}