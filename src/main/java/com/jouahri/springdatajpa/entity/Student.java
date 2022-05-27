package com.jouahri.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "tbl_student",
        uniqueConstraints =  @UniqueConstraint(
                name = "email_id_unique",
                columnNames = {"email_address"}
        )
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence_name",
            allocationSize = 5,
            initialValue = 10
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;
}