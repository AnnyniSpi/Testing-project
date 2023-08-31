package sia.testing.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sia.testing.dto.AnswerDto;
import sia.testing.dto.QuestionDto;
import sia.testing.models.Answer;
import sia.testing.models.Question;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuestionConverter {

    private final AnswerConverter answerConverter;

    public Question toEntity(QuestionDto questionDto){
        Question question = Question.builder()
                .questionText(questionDto.questionText())
                .build();

        Set<Answer> answers = questionDto.answers().stream()
                .map(answer -> answerConverter.toEntity(answer))
                .collect(Collectors.toSet());

        answers.forEach(answer -> question.addAnswer(answer));

        return question;
    }

    public QuestionDto toDto(Question question){

        List<AnswerDto> answers = question.getAnswers().stream()
                .map(answer -> answerConverter.toDto(answer))
                .collect(Collectors.toList());

        return QuestionDto.builder()
                .questionText(question.getQuestionText())
                .answers(answers)
                .build();
    }
}
