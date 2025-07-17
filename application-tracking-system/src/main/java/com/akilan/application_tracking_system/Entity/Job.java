package com.akilan.application_tracking_system.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    @Lob
    private String jobDescription;
    private LocalDate postedDate;

    @OneToMany(mappedBy = "job")
    private List<Application> applications;

}
