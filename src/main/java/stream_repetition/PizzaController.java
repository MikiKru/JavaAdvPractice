package stream_repetition;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
public class PizzaController {
    private void getAllPizzas(){
        Arrays.stream(Pizza.values()).forEach(System.out::println);
    }
    private List<Pizza> getAllSpicy(){
        // filtrowanie po pizzach ostrych
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(Ingredient::isSpicy))
                .collect(Collectors.toList());
    }
    private Pizza findCheapestSpicy(){
        for (Pizza p : getAllSpicy()) {
            int cumSum = 0;
            for(Ingredient i : p.getIngredients()){
                cumSum += i.getPrice();
            }
            System.out.println("Pizza: " + p + " cena: " +cumSum);
        }
        return null;
//        return getAllSpicy().stream()
//                .forEach(pizza -> pizza.getIngredients().stream().forEach(ingredient -> {
//                    cumSum += ingredient.getPrice();
//                }));
    }
    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
//        pc.getAllPizzas();
        System.out.println(pc.getAllSpicy());
        pc.findCheapestSpicy();
    }
}
