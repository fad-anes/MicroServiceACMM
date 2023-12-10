package com.example.microservices.Entity;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table( name = "Question")
public class Question implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idQuestion")
    private Long idQuestion;
    private LocalDateTime timestamp;
    @Column(columnDefinition = "TEXT")
    private String questionText;
    private boolean answered;
}