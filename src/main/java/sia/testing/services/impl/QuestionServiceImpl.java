package sia.testing.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sia.testing.converters.QuestionConverter;
import sia.testing.dto.QuestionDto;
import sia.testing.models.Question;
import sia.testing.repositories.QuestionRepository;
import sia.testing.services.QuestionService;

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
}
