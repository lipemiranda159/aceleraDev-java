package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Acceleration Class Model
 */
@Entity(name=Constants.ACCELERATION_ENTITY_NAME)
@Table(name = Constants.ACCELERATION_TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Acceleration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<Candidate> candidates;


    @ManyToOne
    @JoinColumn(name = Constants.CHALLENGE_ID_FIELD, referencedColumnName = Constants.ID_REFERENCE_FIELD)
    private Challenge challenge;

    @NotNull
    @NotBlank
    @Size(min = Constants.MIN_LENGTH, max = Constants.NAME_FIELDS)
    private String name;
    @NotNull
    @NotBlank
    @Size(min = Constants.MIN_LENGTH, max = Constants.SLUG_FIELDS)
    private String slug;

    @NotNull
    @CreatedDate
    @Column(name = Constants.CREATED_AT_NAME)
    public LocalDateTime createdAt;

}
