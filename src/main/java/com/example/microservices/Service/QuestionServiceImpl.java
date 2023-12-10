package com.example.microservices.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.microservices.Entity.Question;
import com.example.microservices.Repository.QuestionRepository;
import java.util.*;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionRepository questionrepo;

    @Override
    public List<Question> retrieveAllQuestions() {
        return questionrepo.findAll();
    }

    @Override
    public Question addQuestion(Question q) {
        return questionrepo.save(q);
    }

    @Override
    public Question updateQuestion(Question q) {
        return questionrepo.save(q);
    }

    @Override
    public void removeQuestion(Long idQuestion) {
        questionrepo.deleteById(idQuestion);
    }

    @Override
    public Question retrieveQuestion(Long idQuestion) {
        Optional<Question> optionalQuestion = questionrepo.findById(idQuestion);
        return optionalQuestion.orElse(null);
    }
}
