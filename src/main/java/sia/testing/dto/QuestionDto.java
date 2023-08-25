package sia.testing.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;
import java.util.List;

@Builder
@Validated
public record QuestionDto(

        @NotEmpty(message = "Question text is required attribute!")
        String questionText,

        @NotEmpty(message = "Answers are required attribute! ")
        @Size(message = "Collection must contain exactly 4 elements!", min = 4, max = 4)
        List<@Valid AnswerDto> answers) {
}
