package alex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Address {

    @NotBlank
    @Size(min = 5, max = 20, message = "Street name must be between 5 and 20")
    private String street;

    @Size(min = 2, max = 2, message = "State only allows 2 characters")
    private String state;
    private String zipCode;
}
