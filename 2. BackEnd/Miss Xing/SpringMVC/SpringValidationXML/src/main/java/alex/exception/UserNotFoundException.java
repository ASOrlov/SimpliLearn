package alex.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@AllArgsConstructor
@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "This is bad request ...")
public class UserNotFoundException  extends RuntimeException{
    private String message;

}
