package sia.testing.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sia.testing.dto.QuestionDto;
import sia.testing.dto.CheckDto;
import sia.testing.services.QuestionService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

   private final QuestionService questionService;

   @PostMapping
   public ResponseEntity<QuestionDto> createQuestion(@Valid @RequestBody QuestionDto questionDto){
      QuestionDto savedQuestion = questionService.createQuestion(questionDto);
      return ResponseEntity
              .ok()
              .body(savedQuestion);
   }

   @GetMapping("/{id}")
   public ResponseEntity<QuestionDto> findById(@PathVariable("id") Long questionId){
      return ResponseEntity
              .ok()
              .body(questionService.findById(questionId));
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void deleteQuestion(@PathVariable("id") Long questionId){
      questionService.deleteQuestion(questionId);
   }

   @GetMapping
   public List<QuestionDto> getAllQuestions(){
      return questionService.findAll();
   }

   @PostMapping("/check")
   public Integer checkAnswers(@RequestBody List<CheckDto> userAnswer){
      return questionService.checkAnswer(userAnswer);
   }

}
