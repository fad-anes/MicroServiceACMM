package com.example.microservices.Service;

import com.example.microservices.Entity.Answer;

import java.util.Date;
import java.util.List;

public interface IAnswerService {
    List<Answer> retrieveAllAnswers();

    Answer addAnswer(Answer a);

    Answer updateAnswer(Answer a);

    Answer retrieveAnswer(Long idAnswer);

    void removeAnswer(Long idAnswer);

    List<Answer> findAnswersByTimestampRange(Date timestampStart, Date timestampEnd);
}
