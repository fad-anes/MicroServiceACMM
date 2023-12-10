package com.example.microservices.Repository;

import com.example.microservices.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
    List<Answer> findByTimestampBetween(Date timestampStart, Date timestampEnd);
}
