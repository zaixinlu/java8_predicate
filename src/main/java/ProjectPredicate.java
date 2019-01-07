public interface ProjectPredicate {

    boolean test(Project project);

}

class ProjectLanguagePredicate implements ProjectPredicate {

    private String language;

    public ProjectLanguagePredicate(String language) {
        this.language = language;
    }

    public boolean test(Project project) {
        return language.equals(project.getLanguage());
    }
}


class ProjectStarPredicate implements ProjectPredicate {

    private Integer stars;

    public ProjectStarPredicate(Integer stars) {
        this.stars = stars;
    }


    public boolean test(Project project) {
        return project.getStars() > stars;
    }

}
