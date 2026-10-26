package cl.bennu.controljornadabackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
CREATE TABLE country (
    id INTEGER NOT NULL
    , name VARCHAR(200) NOT NULL
	, nationality VARCHAR(200) NOT NULL

 	, PRIMARY KEY (id)
 	, UNIQUE(id)
	, UNIQUE(name)
);
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    private Integer id;
    private String name;
    private String nationality;
}
