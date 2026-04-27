package bt.btap2604.model.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoDTO {
    private Long id;
    @NotBlank(message = "Nội dung không được để trống")
    private String content;
    @NotNull(message = "Ngày hết hạn không được để trống")
    @FutureOrPresent(message = "Ngày hết hạn phải là ngày trong tương lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @NotBlank(message = "Trạng thái không được để trống")
    private String status;
    @NotBlank(message = "Độ ưu tiên không được để trống")
    private String priority;
}