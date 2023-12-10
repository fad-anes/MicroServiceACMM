package com.example.microservices.Service;
import com.example.microservices.Entity.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> retrieveAllQuestions();

    Question addQuestion(Question q);

    Question updateQuestion(Question q);

    void removeQuestion(Long idQuestion);

    Question retrieveQuestion(Long idQuestion);
}
