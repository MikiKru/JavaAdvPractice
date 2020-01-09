package repetition;

// Wykorzystujemy STRAEAM API LAMBDA I OPTIONAL
public class ProjectsController implements Projects {
    // metoda wypisująca wszystkie projekty
    public void getAllProjects(){
        projects.stream().forEach(projects -> System.out.println(projects));
//        projects.stream().forEach(System.out::println);
//        projects.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ProjectsController pc = new ProjectsController();
        pc.getAllProjects();
    }
}
