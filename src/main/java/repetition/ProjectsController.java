package repetition;
import java.util.List;
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
        return 
    }

    public static void main(String[] args) {
        ProjectsController pc = new ProjectsController();
        pc.getAllProjects();
    }
}
