package com.training.mongodb.mongodbproj.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Employee {

    @Id
    private String employeeId;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Min(10)
    @Max(300)
    private Integer weight;
    @Min(50)
    @Max(300)
    private Integer height;

    private PersonDetails personDetails;

    private List<Phone> phones;

    @DBRef
    private List<Comment> comments;

    public Employee(){
        super();
    }

}
