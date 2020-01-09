package repetition;
import java.util.Comparator;
import java.util.List;
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

    public static void main(String[] args) {
        ProjectsController pc = new ProjectsController();
//        pc.getProjectsOrderByBudgetDESC().stream()
//                .forEach(projectsFounds -> System.out.printf("Acronim: %-25s Budget: %20.2f PLN \n",
//                        projectsFounds.getAcronim(),
//                        projectsFounds.getBudget()));
        //        pc.getAllProjects();
                    pc.getProjectsOrderByBudgetASCWithCategoryItAndEngineering().forEach(System.out::println);
    }
}
