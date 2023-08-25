package sia.testing.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Builder
@Validated
public record AnswerDto(

        @NotEmpty(message = "Answer text is required attribute!")
        String answerText,

        @NotNull(message = "Right answer is required attribute!")
        boolean isRightAnswer) {
}
