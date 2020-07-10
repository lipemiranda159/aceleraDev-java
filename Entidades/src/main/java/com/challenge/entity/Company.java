package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Company Class Model
 */
@Entity(name=Constants.COMPANY_ENTITY_NAME)
@Table(name = Constants.COMPANY_TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Company implements Serializable {
    @OneToMany
    private Set<Candidate> candidates;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
