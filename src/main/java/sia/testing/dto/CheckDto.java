package sia.testing.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

@Validated
@Builder
public record CheckDto(

        @NotEmpty(message = "Question are required attribute!")
        String question,

        @NotEmpty(message = "Answer are required attribute!")
        String answer
)
{

}
