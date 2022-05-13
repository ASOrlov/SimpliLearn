package alex.domain;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class Address {

    //@NotBlank(message = "Street must have value")
    @NotBlank(message = "{addr.street}")
    private String street;

    @Size(min=2, max=2, message = "Size of state must be 2")
    private String state;

    @NotNull(message = "Zipcode is a required field")
    private Integer zipcode;

}
