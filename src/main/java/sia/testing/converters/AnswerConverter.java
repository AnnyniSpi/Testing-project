package sia.testing.converters;

import org.springframework.stereotype.Component;
import sia.testing.dto.AnswerDto;
import sia.testing.models.Answer;

@Component
public class AnswerConverter {

    public Answer toEntity(AnswerDto answerDto){
        return Answer.builder()
                .answerText(answerDto.answerText())
                .isRightAnswer(answerDto.isRightAnswer())
                .build();
    }

    public AnswerDto toDto(Answer answer) {
        return AnswerDto.builder()
                .answerText(answer.getAnswerText())
                .isRightAnswer(answer.isRightAnswer())
                .build();
    }
}
