package searching;
import Food.FoodItem.Food;
import java.util.List; 

public class searchByName{
    public static Food nameSearch(List<Food> items, String name) {
        int low = 0;
        int high = items.size() - 1;
        
        while (low <= high && name.compareTo(items.get(low).getName()) >= 0 && name.compareTo(items.get(high).getName()) <= 0) {
            if (low == high) {
                if (items.get(low).getName().equals(name)) {
                    return items.get(low);
                }
                return null;
            }
            
            if (items.get(high).getName().equals(items.get(low).getName())) {
                if (items.get(low).getName().equals(name)) {
                    return items.get(low);
                }
                return null;
            }
            
            int pos = low + ((name.compareTo(items.get(low).getName()) * (high - low)) /
                    items.get(high).getName().compareTo(items.get(low).getName()));
            
            if (items.get(pos).getName().equals(name)) {
                return items.get(pos);
            } else if (items.get(pos).getName().compareTo(name) < 0) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return null;
    }
}
