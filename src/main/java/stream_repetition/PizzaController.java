package stream_repetition;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
                .filter(pizza -> pizza.getIngredients().stream().allMatch(ingredient -> !ingredient.isMeat()))
                .max(Comparator.comparing(pizza -> calculatePizzaPrice(pizza)))
                .get();
    }
    private String formattedMenu(){
        return Arrays.stream(Pizza.values())
                .map(pizza ->
                {
                    return String.format("Pizza: %15s | Cena %d PLN | Składniki: %-100s",
                            pizza.getName(),
                            calculatePizzaPrice(pizza),
                            pizza.getIngredients().stream()
                                    .map(ingredient -> ingredient.getName())
                                    .collect(Collectors.joining(", ")));
                }).collect(Collectors.joining("\n"));
    }
    private List<Pizza> getAllPizzasOrderByPrice(){
        return Arrays.stream(Pizza.values())
                .sorted(Comparator.comparing(pizza -> calculatePizzaPrice(pizza)))
                .collect(Collectors.toList());
    }
    private String formattedMenuOrderByPrice(){
        return getAllPizzasOrderByPrice().stream()
                .map(pizza ->
                {
                    return String.format("Pizza: %15s | Cena %d PLN | Składniki: %-100s",
                            pizza.getName(),
                            calculatePizzaPrice(pizza),
                            pizza.getIngredients().stream()
                                    .map(ingredient -> ingredient.getName())
                                    .collect(Collectors.joining(", ")));
                }).collect(Collectors.joining("\n"));
    }
    // zawaca pizze mięsne posortowanie po ilości wszystkich składników
    private List<Pizza> iLikeMeat(){
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isMeat()))
                .sorted(Comparator.comparing(pizza -> pizza.getIngredients().size()))
                .collect(Collectors.toList());
    }
    // zwraca pizze mięsne posotrowane po ilości składików mięsnych
    private List<Pizza> iLikeMeatOrderByMeatIngredients(){
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isMeat()))
                .sorted(Comparator.comparing(pizza -> pizza.getIngredients().stream()
                                                .filter(ingredient -> ingredient.isMeat())
                                                .count()))
                .collect(Collectors.toList());
    }
    // zwraca nazwę pizzy z nazwami jej skłaników mięsnych
    private String getPizzaWithMeatIngredients(Pizza pizza){
        return pizza.getName() + " | " +pizza.getIngredients().stream()
                    .map(ingredient -> String.format("%s \n",
                                            pizza.getIngredients().stream()
                                                    .filter(ingred1 -> ingred1.isMeat())
                                                    .map(ingred2 -> ingred2.getName())
                                                    .collect(Collectors.joining(", "))))
                    .collect(Collectors.joining());
    }
    // grupowanie pizz po cenie
    private Map groupPizzasByPrice(){
        return Arrays.stream(Pizza.values())
                .collect(Collectors.groupingBy(pizza -> calculatePizzaPrice(pizza)));
    }
    public static void main(String[] args) {
        PizzaController pc = new PizzaController();
        pc.groupPizzasByPrice().forEach((key, value) -> System.out.println(key + " : " + value));
//        pc.iLikeMeatOrderByMeatIngredients().forEach(pizza -> System.out.printf("%15s | %10d | %10s \n",
//                pizza,
//                pc.calculatePizzaPrice(pizza),
//                pc.getPizzaWithMeatIngredients(pizza)));

        //        System.out.println(pc.formattedMenuOrderByPrice());
//        //        pc.getAllPizzas();
////        System.out.println(pc.getAllSpicy());
//        System.out.printf("Nazwa: %s | Cena: %d PLN\n",
//                pc.findCheapestSpicy(), pc.calculatePizzaPrice(pc.findCheapestSpicy()));
//        System.out.printf("Nazwa: %s | Cena: %d PLN\n",
//                pc.findMostExpensiveVergetarian(), pc.calculatePizzaPrice(pc.findMostExpensiveVergetarian()));

    }
}
