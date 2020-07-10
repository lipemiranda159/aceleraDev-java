package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Submission Class Model
 */
@Entity(name=Constants.SUBMISSION_ENTITY_NAME)
@Table(name = Constants.SUBMISSION_TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Submission implements Serializable {

    @EmbeddedId
    private SubmissionIdentity submissionIdentity;

    @NotNull
    private float score;

    @NotNull
    @CreatedDate
    @Column(name = Constants.CREATED_AT_NAME)
    public LocalDateTime createdAt;

    public SubmissionIdentity getSubmissionIdentity() {
        return submissionIdentity;
    }

    public void setSubmissionIdentity(SubmissionIdentity submissionIdentity) {
        this.submissionIdentity = submissionIdentity;
    }
}
