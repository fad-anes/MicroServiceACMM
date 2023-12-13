package com.example.microservices.Service;

import com.example.microservices.Entity.Answer;
import com.example.microservices.Repository.AnswerRepository;
import com.example.microservices.Repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    public AnswerRepository answerRepo;
    @Autowired
    public QuestionRepository questionRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepo) {
        this.answerRepo = answerRepo;
    }

    @Override
    public List<Answer> retrieveAllAnswers() {
        return answerRepo.findAll();
    }

    @Override
    public Answer addAnswer(Answer a, Long quesid) {
        a.setQuestion(this.questionRepository.findQuestionByIdQuestion(quesid).get());
        a.setTimestamp(LocalDateTime.now());
        return answerRepo.save(a);
    }

    @Override
    public Answer updateAnswer(Answer a) {
        return answerRepo.save(a);
    }

    @Override
    public Answer retrieveAnswer(Long idAnswer) {
        Optional<Answer> optionalAnswer = answerRepo.findById(idAnswer);
        return optionalAnswer.orElse(null);
    }

    @Override
    public void removeAnswer(Long idAnswer) {
        answerRepo.deleteById(idAnswer);
    }

    @Override
    public List<Answer> findAnswersByTimestampRange(Date timestampStart, Date timestampEnd) {
        return answerRepo.findByTimestampBetween(timestampStart, timestampEnd);
    }
    @Override
    public List<Answer> findByUserId(Long userId){return  answerRepo.findByUserId(userId);}
}
