package sia.testing.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sia.testing.converters.QuestionConverter;
import sia.testing.dto.QuestionDto;
import sia.testing.dto.CheckDto;
import sia.testing.models.Question;
import sia.testing.repositories.QuestionRepository;
import sia.testing.services.QuestionService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionConverter questionConverter;

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        Question question = questionConverter.toEntity(questionDto);

        Question savedQuestion = questionRepository.save(question);

        return questionConverter.toDto(savedQuestion);
    }

    @Override
    public QuestionDto findById(Long questionId) {
         Question question = questionRepository.findById(questionId).orElseThrow(() ->
                 new RuntimeException("Question by id Not found"));

        return questionConverter.toDto(question);
    }

//    @Override
//    public void updateQuestion(Long questionId, QuestionDto questionDto) {
//    }

    @Override
    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    public List<QuestionDto> findAll() {
        List<Question> allQuestion = questionRepository.findAll();

        return allQuestion.stream()
                .map(entity -> questionConverter.toDto(entity))
                .toList();
    }

    @Override
    public Integer checkAnswer(List<CheckDto> checkDto) {
        AtomicInteger count = new AtomicInteger();

        checkDto.forEach(check -> {
            Question questionByText = questionRepository.findByQuestionText(check.question());
            questionByText.getAnswers().forEach(answer -> {
                if (answer.equals(check.answer())){
                    if (answer.isRightAnswer()){
                      count.getAndIncrement();
                    }
                }
            });
        });

        return count.get();

    }
}
