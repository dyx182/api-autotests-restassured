package petstore.models;

import java.util.List;

public class Pet {
    private String id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tags> tags;
    private String status;

    public Pet(String id, Category category, String name, List<String> photoUrls, List<Tags> tags, String status) {
        this.id = id;
        this.status = status;
        this.tags = tags;
        this.name = name;
        this.category = category;
        this.photoUrls = photoUrls;
    }
}
