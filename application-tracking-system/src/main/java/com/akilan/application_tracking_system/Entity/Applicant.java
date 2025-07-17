package com.akilan.application_tracking_system.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL)
    private Resume resume;

    @OneToMany(mappedBy = "applicant",cascade = CascadeType.ALL)
    private List<Application> applications;

}
