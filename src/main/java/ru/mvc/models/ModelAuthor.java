package ru.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelAuthor {
    private int id;
    private String firstName;
    private String lastName;
    private List<ModelBook> books = new ArrayList<>();


}
