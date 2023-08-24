package sia.testing.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sia.testing.models.Question;
import sia.testing.repositories.QuestionsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionsServiceImp implements QuestionsService {

    private final QuestionsRepository questionsRepo;

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questionsRepo.findAll().forEach(question -> questions.add(question));
        return questions;
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionsRepo.findById(id).get();
    }

    @Override
    public Question insert(Question question) {
        return questionsRepo.save(question);
    }

    @Override
    public void updateQuestion(Long id, Question question) {
        Question questionFromDb = questionsRepo.findById(id).get();
        System.out.println(questionFromDb.toString());
        questionFromDb.setBodyQuestion(question.getBodyQuestion());
        questionFromDb.setAnswers(question.getAnswers());
        questionsRepo.save(questionFromDb);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionsRepo.deleteById(id);
    }
}
