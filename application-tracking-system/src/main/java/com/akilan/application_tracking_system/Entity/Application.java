package com.akilan.application_tracking_system.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "jobId",nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "applicantId",nullable = false)
    private Applicant applicant;

}
