package alex.thymeleafxpressionsyntax.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private Address address;


    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
