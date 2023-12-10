package com.example.microservices.Service;

import com.example.microservices.Entity.Answer;
import com.example.microservices.Entity.Question;
import com.example.microservices.Repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements IAnswerService {
    AnswerRepository answerrepo;
    @Override
    public List<Answer> retrieveAllAnswers(){return answerrepo.findAll();};
    @Override
    public Answer addAnswer(Answer a) {
        return answerrepo.save(a);
    }
    @Override
    public Answer updateAnswer(Answer a){return answerrepo.save(a);};
    @Override
    public Answer retrieveAnswer(Long idAnswer) {
        Optional<Answer> optionalAnswer = answerrepo.findById(idAnswer);
        return optionalAnswer.orElse(null);
    }
    @Override
    public void removeAnswer(Long idAnswer){answerrepo.deleteById(idAnswer);};
    @Override
    public List<Answer> findAnswersByTimestampRange(Date timestampStart, Date timestampEnd) {
        return answerrepo.findByTimestampBetween(timestampStart, timestampEnd);
    }
}
