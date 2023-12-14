package com.example.microservices.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
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
    @Column(name = "id_user")
    private Long userId;

    private LocalDateTime timestamp;
    @Column(columnDefinition = "TEXT")
    private String answerText;
    @JsonIgnore
    @OneToOne private Question question ;
}
