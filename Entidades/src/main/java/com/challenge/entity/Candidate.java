package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Candidate Class Model
 */
@Entity(name=Constants.CANDIDATE_ENTITY_NAME)
@Table(name = Constants.CANDIDATE_TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Candidate implements Serializable {

    @EmbeddedId
    private CandidateIdentity candidateIdentity;
    @NotNull
    private short status;

    @NotNull
    @CreatedDate
    @Column(name = Constants.CREATED_AT_NAME)
    public LocalDateTime createdAt;

    public CandidateIdentity getCandidateIdentity() {
        return candidateIdentity;
    }

    public void setCandidateIdentity(CandidateIdentity candidateIdentity) {
        this.candidateIdentity = candidateIdentity;
    }
}
