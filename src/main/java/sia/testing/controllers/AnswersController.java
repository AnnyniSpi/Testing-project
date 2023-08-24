package sia.testing.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sia.testing.models.Answer;
import sia.testing.services.AnswersService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/answers")
public class AnswersController {

    private final AnswersService answersService;

    @GetMapping
    public ResponseEntity<List<Answer>> findAllAnswer(){
        List<Answer> answers = answersService.getAnswers();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping({"/{answerId}"})
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long answerId){
        return new ResponseEntity<>(answersService.getAnswerById(answerId), HttpStatus.OK);
    }

    public ResponseEntity<Answer> saveAnswer(@RequestBody Answer answer){
        Answer newAnswer = answersService.insert(answer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("answer", "/answers/" + newAnswer.getId());
        return new ResponseEntity<>(newAnswer, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{answerId}"})
    public ResponseEntity<Answer> updateAnswer(@PathVariable("answerId") Long answerId,
                                               @RequestBody Answer answer){
        answersService.updateAnswer(answerId, answer);
        return new ResponseEntity<>(answersService.getAnswerById(answerId), HttpStatus.OK);
    }

    @DeleteMapping({"/{answerId}"})
    public ResponseEntity<Answer> deleteAnswer(@PathVariable("answerId") Long answerId){
        answersService.deleteAnswer(answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
