package Altaneo.ed_tech.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public static <T> ResponseEntity<ApiResponse<T>> send(int status, String message, T data) {
        return ResponseEntity.status(HttpStatus.valueOf(status))
                .body(new ApiResponse<>(status, message, data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> send(int status, String message) {
        return send(status, message, null);
    }
}
