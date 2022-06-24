package alex.domain;



import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Employee {

    @NotNull(message = "id cannot be Null")
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 12, message = "First name must be between 2 and 12")
    private String firstName;

    private String lastName;

    @Valid
    private Address address;
}
