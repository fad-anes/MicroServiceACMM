package com.example.microservices.Repository;

import com.example.microservices.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findByUserId(Long userId);
    public Optional<Question>  findQuestionByIdQuestion(Long idQuestion);
}
