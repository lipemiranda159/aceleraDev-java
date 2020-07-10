package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * User Class Model
 */
@Entity(name = Constants.USER_ENTITY_NAME)
@Table(name = Constants.USER_TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Size(min = Constants.MIN_LENGTH, max = Constants.FULL_NAME_LENGTH)
    private String fullName;
    @NotNull
    @NotBlank
    @Email
    @Size(min = Constants.MIN_LENGTH, max = Constants.MAIL_LENGTH)
    private String email;
    @NotNull
    @NotBlank
    @Size(min = Constants.MIN_LENGTH, max = Constants.NICKNAME_LENGTH)
    private String nickname;
    @NotNull
    @NotBlank
    @Size(min = Constants.MIN_LENGTH, max = Constants.PASSWORD_LENGTH)
    private String password;

    @OneToMany
    private Set<Candidate> candidates;
    @OneToMany
    private Set<Submission> submissions;

    @NotNull
    @CreatedDate
    @Column(name = Constants.CREATED_AT_NAME)
    public LocalDateTime createdAt;
}
