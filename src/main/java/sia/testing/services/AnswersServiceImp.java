package sia.testing.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sia.testing.models.Answer;
import sia.testing.repositories.AnswersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswersServiceImp implements AnswersService{

    private final AnswersRepository answersRepo;

    @Override
    public List<Answer> getAnswers() {
        List<Answer> answers = new ArrayList<>();
        answersRepo.findAll().forEach(answer -> answers.add(answer));
        return answers;
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answersRepo.findById(id).get();
    }

    @Override
    public Answer insert(Answer answer) {
        return answersRepo.save(answer);
    }

    @Override
    public void updateAnswer(Long id, Answer answer) {
        Answer answerFromDb = answersRepo.findById(id).get();
        System.out.println(answerFromDb.toString());
        answerFromDb.setTextAnswer(answer.getTextAnswer());
        answerFromDb.setBooleanResponse(answer.isBooleanResponse());
        answerFromDb.setQuestion(answer.getQuestion());
        answersRepo.save(answerFromDb);
    }

    @Override
    public void deleteAnswer(Long id) {
        answersRepo.deleteById(id);
    }
}
