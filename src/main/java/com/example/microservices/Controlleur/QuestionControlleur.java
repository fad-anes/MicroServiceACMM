package com.example.microservices.Controlleur;

import com.example.microservices.Entity.Question;
import com.example.microservices.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionControlleur {

    private final IQuestionService questionService;

    @Autowired
    public QuestionControlleur(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/allQuestions")
    public List<Question> retrieveAllQuestions() {
        return questionService.retrieveAllQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionService.retrieveQuestion(id);
        if (question != null) {
            return new ResponseEntity<>(question, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addQuestion")
    public Question addQuestion(@RequestBody Question q) {
        return questionService.addQuestion(q);
    }

    @PutMapping("/updateQuestion")
    public Question updateQuestion(@RequestBody Question q) {
        return questionService.updateQuestion(q);
    }

    @DeleteMapping("/removeQuestion/{id}")
    public void removeQuestion(@PathVariable("id") Long id) {
        questionService.removeQuestion(id);
    }
}
