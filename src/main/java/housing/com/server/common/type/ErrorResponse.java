package housing.com.server.common.type;

import lombok.*;
import org.springframework.http.HttpStatusCode;

import java.util.Date;

@Getter @Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponse{


    @NonNull
    private String message;
    private Date timestamp = new Date();
    private StackTraceElement[] stack;

}
