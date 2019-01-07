import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Project {

    private String name;

    private String language;

    private Integer stars;

    private String description;

    private String author;

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", stars=" + stars +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                "}\n";
    }
}