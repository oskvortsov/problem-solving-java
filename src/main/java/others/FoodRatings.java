package others;

import java.util.*;

// https://leetcode.com/problems/design-a-food-rating-system/
public class FoodRatings {
    class Dish implements Comparable<Dish> {
        String cuisine;
        String name;
        int rate;

        Dish(String cuisine, String name, int rate) {
            this.cuisine = cuisine;
            this.name = name;
            this.rate = rate;
        }

        @Override
        public int compareTo(Dish obj) {
            if (this.rate == obj.rate) {
                return this.name.compareTo(obj.name);
            }

            return obj.rate - this.rate;
        }
    }

    HashMap<String, Dish> dishByFood;
    HashMap<String, TreeSet<Dish>> ratingByCuisine;



    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        dishByFood = new HashMap<>();
        ratingByCuisine = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Dish dish = new Dish(cuisines[i], foods[i], ratings[i]);

            dishByFood.put(dish.name, dish);
            TreeSet<Dish> set = ratingByCuisine.getOrDefault(dish.cuisine, new TreeSet<>());
            set.add(dish);
            ratingByCuisine.put(dish.cuisine, set);
        }
    }

    public void changeRating(String food, int newRating) {
        Dish dish = dishByFood.get(food);
        TreeSet<Dish> set = ratingByCuisine.get(dish.cuisine);
        set.remove(dish);

        dish.rate = newRating;
        set.add(dish);
    }

    public String highestRated(String cuisine) {
        Dish dish = ratingByCuisine.get(cuisine).first();
        return dish != null ? dish.name : null;
    }
}
