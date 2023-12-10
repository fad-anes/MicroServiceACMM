package com.example.microservices.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="Answer")
public class Answer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAnswer")
    private Long idAnswer;
    private LocalDateTime timestamp;
    @Column(columnDefinition = "TEXT")
    private String answerText;
}
