package alex.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class User {
    //@Size(min=2, max=30, message="Size of the Name must be lie between 2 and 30")
    @Size(min=2, max=30, message = "{abc}")
    private String name;

    @Email(message = "Email must follow the formatter: ***@***.com")
    @NotBlank(message = "Email must have a value")
    private String email;

    @Min(value = 18, message = "Must be greater or equal to 18")
    //@NotNull(message = "Age is a required field")
    @NotNull(message = "{notnull.age}")
    private Integer age;

    @NotNull(message = "Birthday is requierd field")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate birthday;

    @NotBlank(message = "Role must have a value")
    private String role;

    @Valid
    private Address address;
}
