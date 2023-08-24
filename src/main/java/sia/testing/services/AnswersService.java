package sia.testing.services;

import sia.testing.models.Answer;

import java.util.List;

public interface AnswersService {

    List<Answer> getAnswers();

    Answer getAnswerById(Long id);

    Answer insert(Answer answer);

    void updateAnswer(Long id, Answer answer);

    void deleteAnswer(Long id);
}
