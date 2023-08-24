package sia.testing.services;

import sia.testing.models.Answer;
import sia.testing.models.Question;

import java.util.List;

public interface QuestionsService {

    List<Question> getQuestions();

    Question getQuestionById(Long id);

    Question insert(Question question);

    void updateQuestion(Long id, Question question);

    void deleteQuestion(Long id);
}
