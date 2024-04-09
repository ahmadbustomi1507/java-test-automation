package dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    @JsonIgnore
    private String createdAt;

    //@JsonAlias("name")
    private String name;


    private String avatar;
    private String id;


}
