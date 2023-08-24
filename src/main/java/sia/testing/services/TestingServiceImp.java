package sia.testing.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sia.testing.models.Answer;
import sia.testing.models.Question;
import sia.testing.repositories.AnswersRepository;
import sia.testing.repositories.QuestionsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TestingServiceImp implements TestingService {

    private final QuestionsRepository questionsRepo;

    @Override
    public String checkResultAnswerOnQuestion() {
        List<Question> questions = new ArrayList<>();
        questionsRepo.findAll().forEach(question -> questions.add(question));

//        questionsRepo.findById(2L).map(Question::getAnswers)
//                .filter(answer -> answer.)

        for (Question question : questions) {
            Set<Answer> answers = question.getAnswers();
            for (Answer answer : answers) {
                if (answer.isBooleanResponse()){
                    return "true";
                }
                return "false";
            }
        }
        return "";
    }

}
