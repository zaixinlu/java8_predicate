import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProjectFilter {

    public static List<Project> filterJavaProjects(List<Project> projects) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if ("java".equals(project.getLanguage())) {
                result.add(project);
            }
        }
        return result;
    }

    public static List<Project> filterLanguageProjects(List<Project> projects, String language) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (language != null && language.equals(project.getLanguage())) {
                result.add(project);
            }
        }
        return result;
    }

    public static List<Project> filterLanguageAndStarProjects(List<Project> projects, String language, int stars) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (language != null && language.equals(project.getLanguage()) && project.getStars() > stars) {
                result.add(project);
            }
        }
        return result;
    }

    public static List<Project> filterProjects(List<Project> projects, ProjectPredicate projectPredicate) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (projectPredicate.test(project)) {
                result.add(project);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Project> data = new ArrayList<>();

        data.add(Project.builder().name("Blade").language("java").author("biezhi")
                .stars(3500).description("Lightning fast and elegant mvc framework for Java8").build());

        data.add(Project.builder().name("Tale").language("java").author("biezhi")
                .stars(2600).description("Best beautiful java blog, worth a try").build());

        data.add(Project.builder().name("React.js").language("js").author("zaixin")
                .stars(83000).description("A progressive, incrementally-adoptable JavaScript framework for building UI on the web.").build());

        data.add(Project.builder().name("Flask").language("python").author("zaixin")
                .stars(10500).description("The Python micro framework for building web applications").build());

        data.add(Project.builder().name("Elves").language("java").author("yigao")
                .stars(200).description("Spider").build());

        data.add(new Project("","",0,"",""));

        List<Project> projects = filterJavaProjects(data);

        projects = filterLanguageProjects(data, "python");
        System.out.println(projects.size());

        projects = filterLanguageAndStarProjects(data, "js", 1000);
        System.out.println(projects.size());

        projects = filterProjects(data, new ProjectLanguagePredicate("python"));
        System.out.println(projects.size());

        projects = filterProjects(data, new ProjectStarPredicate(1000));
        System.out.println(projects.size());

        projects = filterProjects(data, project -> project.getAuthor().equals("zaixin"));
        System.out.println(projects.size());

        data.sort(Comparator.comparing(Project::getStars));
        System.out.println(data);

    }

}
