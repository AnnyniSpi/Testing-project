package sia.testing.services;

import sia.testing.dto.QuestionDto;
import sia.testing.dto.CheckDto;

import java.util.List;

public interface QuestionService {

    public QuestionDto createQuestion(QuestionDto questionDto);

    public QuestionDto findById(Long questionId);

//    public void updateQuestion(Long questionId, QuestionDto questionDto);

    public void deleteQuestion(Long questionId);

    public List<QuestionDto> findAll();

    public Integer checkAnswer(List<CheckDto> checkDto);

}
