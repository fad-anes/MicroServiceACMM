package com.example.microservices.Controlleur;

import com.example.microservices.Entity.Answer;
import com.example.microservices.Service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerControlleur {

    private final IAnswerService answerService;

    @Autowired
    public AnswerControlleur(IAnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/allAnswers")
    public List<Answer> retrieveAllAnswers() {
        return answerService.retrieveAllAnswers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        Answer answer = answerService.retrieveAnswer(id);
        if (answer != null) {
            return new ResponseEntity<>(answer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addAnswer")
    public Answer addAnswer(@RequestBody Answer a) {
        return answerService.addAnswer(a);
    }

    @PutMapping("/updateAnswer")
    public Answer updateAnswer(@RequestBody Answer a) {
        return answerService.updateAnswer(a);
    }

    @DeleteMapping("/removeAnswer/{id}")
    public void removeAnswer(@PathVariable("id") Long id) {
        answerService.removeAnswer(id);
    }

    @GetMapping("/byTimestampRange")
    public ResponseEntity<List<Answer>> getAnswersByTimestampRange(
            @RequestParam("timestampStart") Date timestampStart,
            @RequestParam("timestampEnd") Date timestampEnd) {
        try {
            List<Answer> answers = answerService.findAnswersByTimestampRange(timestampStart, timestampEnd);
            return new ResponseEntity<>(answers, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exception, e.g., log it and return a meaningful response
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
