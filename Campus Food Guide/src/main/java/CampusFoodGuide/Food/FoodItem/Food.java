package CampusFoodGuide.Food.FoodItem;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Food {
    private int calories;
    private double price;
    private String name = "";
    private String category = "";
    private String location = "";

    public Food() {
        calories = 0;
        price = 0.0;
        name = "";
        category = "";
        location = "";
    }

    public Food(String _name, String _category, String _location, int _calories, double _price) {
        name = _name;
        category = _category;
        location = _location;
        calories = _calories;
        price = _price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    public Integer getCalories() {
        return calories;
    }

    public Double getPrice() {
        return price;
    }
    
    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + category);
        System.out.println("Cost: " + price);
        System.out.println("Cals: " + calories);
        System.out.println("Located at " + location);
    }

    //Returns a string rather than the location in memory
    public String toString() {
        return "Name: "+this.name+"\n Type: "+this.category+"\n Cost: "+this.price+"\n Cals: "+this.calories+"\n Location: "+this.location+"\n";
    }
}