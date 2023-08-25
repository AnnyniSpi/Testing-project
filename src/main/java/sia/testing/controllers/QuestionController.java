package sia.testing.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sia.testing.dto.QuestionDto;
import sia.testing.services.QuestionService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

   private final QuestionService questionService;

   @PostMapping
   public ResponseEntity<QuestionDto> createQuestion(@Valid @RequestBody QuestionDto questionDto){

      QuestionDto savedQuestion = questionService.createQuestion(questionDto);

      return ResponseEntity
              .ok()
              .body(savedQuestion);
   }
}
