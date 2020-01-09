package repetition;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

// Wykorzystujemy STRAEAM API LAMBDA I OPTIONAL
public class ProjectsController implements Projects {
    // metoda wypisująca wszystkie projekty
    public void getAllProjects(){
        projects.stream().forEach(projects -> System.out.println(projects));
//        projects.stream().forEach(System.out::println);
//        projects.forEach(System.out::println);
    }
    // metoda zwracająca projekty posortowane po budżecie max-min
    public List<ProjectsFounds> getProjectsOrderByBudgetDESC(){
        return projects.stream()                                                                            // zamiana na STREAM
                .sorted(Comparator.comparing(ProjectsFounds::getBudget).reversed())                         // sortowania DESC
                .collect(Collectors.toList());                                                              // zwróć listę
    }
    // metoda zwracająca projekty posortowane po budżecie min-max tylko kategorii IT i Engineering
    public List<ProjectsFounds> getProjectsOrderByBudgetASCWithCategoryItAndEngineering(){
        return projects.stream()
                .filter(projectsFounds -> projectsFounds.getCategory().equals("IT") || projectsFounds.getCategory().equals("Engineering"))  // filtrujemy po kategoriach
                .sorted(Comparator.comparing(ProjectsFounds::getBudget))                                    // sortujemy po budżecie
                .collect(Collectors.toList());                                                              //zwracamy listę
    }
    // metoda zwracająca projekt z najwyższym dofinansowaniem
    public ProjectsFounds getProjectWithMaxFound(){
        return projects.stream()
                .sorted(Comparator.comparing(ProjectsFounds::getFoundByProject).reversed()) // sortowanie po budżecie DESC
                .collect(Collectors.toList())                                       // zapis do listy
                .get(0);                                                            // pobranie pierwszego elementu

    }
    public ProjectsFounds getProjectWithMaxFound2(){
        return projects.stream()
                .max(Comparator.comparing(ProjectsFounds::getFoundByProject))       // zwraca wartość max opakowaną kontenerem Optional
                .get();                                                             // get pobiera wartośc z Optionala
    }
    // metoda zwracająca projekt z najkrótszym czasem trwania
    public ProjectsFounds getProjectWithMinTimeline(){
        return projects.stream()
                .min(Comparator.comparing(ProjectsFounds::getNumberOfMonths))
                .get();
    }
    // metoda zwracająca średni czas trwania projektu
    public Double getAverageProjectsTimelines(){
        return projects.stream()
                .mapToDouble(ProjectsFounds::getNumberOfMonths)     // bierzemy z obiektu projektu tylko miesiące
                .average()                                          // liczymy wartość średnią -> Optional
                .getAsDouble();                                     // pobieramy wartości z Optionala
    }
    // metoda zwracająca całkowitą kwotę dofinansowania dla wszystkich projektów
    public Double sumAllProjectFounds(){
        return projects.stream()
                .mapToDouble(ProjectsFounds::getFoundByProject)     // mapujemy obiekt na liczbę
                .sum();                                             // sumujemy wszystkie liczby
    }
    // ile jest projektów w kategori podajen w argumencie funkcji
    public Integer countProjectsByCategory(String category){
        return (int) projects.stream()
                    .filter(projectsFounds -> projectsFounds.getCategory().equals(category))
                    .count();
    }

    public static void main(String[] args) {
        Locale locale = new Locale("en", "PL");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        ProjectsController pc = new ProjectsController();
        String category = "Education";
        System.out.printf("Number of projects with category %s: %d", category, pc.countProjectsByCategory(category));
//        System.out.println("Całkowite dofinansowanie projektów: " +
//                currencyFormatter.format(pc.sumAllProjectFounds()).replace("PLN", "").replace(",", " ") + " PLN");
        //        System.out.printf("Project timeline: %.1f\n", pc.getAverageProjectsTimelines());
//        System.out.printf("%s %d",
//                pc.getProjectWithMinTimeline().getAcronim(),
//                pc.getProjectWithMinTimeline().getNumberOfMonths());
//        System.out.printf("%s %.2fPLN %.2fPLN\n",
//                pc.getProjectWithMaxFound2().getAcronim(),
//                pc.getProjectWithMaxFound2().getBudget(),
//                pc.getProjectWithMaxFound2().getFoundByProject());
        //        pc.getProjectsOrderByBudgetDESC().stream()
//                .forEach(projectsFounds -> System.out.printf("Acronim: %-25s Budget: %20.2f PLN \n",
//                        projectsFounds.getAcronim(),
//                        projectsFounds.getBudget()));
        //        pc.getAllProjects();
//                    pc.getProjectsOrderByBudgetASCWithCategoryItAndEngineering().forEach(System.out::println);
    }
}
