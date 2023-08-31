package sia.testing.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
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
        @Size(message = "Collection must contain exactly 3 or 4 elements!", min = 3, max = 4)
        List<@Valid AnswerDto> answers) {
}
