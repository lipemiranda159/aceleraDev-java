package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Submission Identity Class Model
 */
@Embeddable
public class SubmissionIdentity implements Serializable {
    @ManyToOne
    @JoinColumn(name = Constants.USER_ID_FIELD, referencedColumnName = Constants.ID_REFERENCE_FIELD)
    private User user;

    @ManyToOne
    @JoinColumn(name = Constants.CHALLENGE_ID_FIELD, referencedColumnName = Constants.ID_REFERENCE_FIELD)
    private Challenge challenge;
}
