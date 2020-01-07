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
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
                .min(Comparator.comparing(pizza -> calculatePizzaPrice(pizza)))
                .get();
    }
    private Pizza findMostExpensiveVergetarian(){
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> !ingredient.isMeat()))
                .max(Comparator.comparing(pizza -> calculatePizzaPrice(pizza)))
                .get();
    }
    private String formattedMenu(){
        return Arrays.stream(Pizza.values())
                .map(pizza ->
                {
                    return String.format("Pizza: %15s | Składniki: %-100s | Cena: %d",
                            pizza.getName(),
                            pizza.getIngredients().stream()
                                    .map(ingredient -> ingredient.getName())
                                    .collect(Collectors.joining(", ")),
                            calculatePizzaPrice(pizza));
                }).collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        System.out.println(pc.formattedMenu());
        //        pc.getAllPizzas();
//        System.out.println(pc.getAllSpicy());
        System.out.printf("Nazwa: %s | Cena: %d PLN\n",
                pc.findCheapestSpicy(), pc.calculatePizzaPrice(pc.findCheapestSpicy()));
        System.out.printf("Nazwa: %s | Cena: %d PLN\n",
                pc.findMostExpensiveVergetarian(), pc.calculatePizzaPrice(pc.findMostExpensiveVergetarian()));

    }
}
