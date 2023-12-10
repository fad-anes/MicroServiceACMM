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
@RequestMapping("/api/answers")
public class AnswerControlleur {

    @Autowired
    private IAnswerService answerService;

    @GetMapping
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = answerService.retrieveAllAnswers();
        return new ResponseEntity<>(answers, HttpStatus.OK);
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

    @PostMapping
    public ResponseEntity<Answer> addAnswer(@RequestBody Answer answer) {
        Answer addedAnswer = answerService.addAnswer(answer);
        return new ResponseEntity<>(addedAnswer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable Long id, @RequestBody Answer answer) {
        Answer updatedAnswer = answerService.updateAnswer(answer);
        return new ResponseEntity<>(updatedAnswer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAnswer(@PathVariable Long id) {
        answerService.removeAnswer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byTimestampRange")
    public ResponseEntity<List<Answer>> getAnswersByTimestampRange(
            @RequestParam("timestampStart") Date timestampStart,
            @RequestParam("timestampEnd") Date timestampEnd) {
        List<Answer> answers = answerService.findAnswersByTimestampRange(timestampStart, timestampEnd);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }
}
