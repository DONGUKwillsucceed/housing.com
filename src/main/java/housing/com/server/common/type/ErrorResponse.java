package housing.com.server.common.type;

import lombok.*;

@Getter @Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponse{

    @NonNull
    private String message;
    private StackTraceElement[] stack;

}
