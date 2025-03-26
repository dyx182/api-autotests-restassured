package petstore.models;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Pet {
    private String id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tags> tags;
    private String status;


}
