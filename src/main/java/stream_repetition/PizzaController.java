package stream_repetition;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
    private int calculatePizzaPrice(Pizza pizza){
        return pizza.getIngredients()
                .stream()
                .mapToInt(Ingredient::getPrice)
                .sum();
    }
    private Pizza findCheapestSpicy(){
        return getAllSpicy().stream().min(Comparator.comparing(pizza -> calculatePizzaPrice(pizza))).get();
    }
    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
//        pc.getAllPizzas();
        System.out.println(pc.getAllSpicy());
        System.out.println(pc.findCheapestSpicy());
    }
}
