package sia.testing.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sia.testing.models.Question;
import sia.testing.services.QuestionsService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionsController {

    private final QuestionsService questionsService;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questions = questionsService.getQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping({"{/questionId}"})
    public ResponseEntity<Question> getQuestionById(@PathVariable Long questionId){
        return new ResponseEntity<>(questionsService.getQuestionById(questionId), HttpStatus.OK);
    }

    public ResponseEntity<Question> saveQuestion(@RequestBody Question question){
        Question newQuestion = questionsService.insert(question);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("question", "/questions/" + newQuestion.getId());
        return new ResponseEntity<>(newQuestion, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{questionId}"})
    public ResponseEntity<Question> updateTodo(@PathVariable("questionId") Long questionId,
                                               @RequestBody Question question){
        questionsService.updateQuestion(questionId, question);
        return new ResponseEntity<>(questionsService.getQuestionById(questionId), HttpStatus.OK);
    }

    @DeleteMapping({"/{questionId}"})
    public ResponseEntity<Question> deleteQuestion(@PathVariable("questionId") Long questionId){
        questionsService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
