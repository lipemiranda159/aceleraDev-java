package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
/**
 * Candidate Identity Class Model
 */
@Embeddable
public class CandidateIdentity implements Serializable {
    @ManyToOne
    @JoinColumn(name = Constants.USER_ID_FIELD, referencedColumnName = Constants.ID_REFERENCE_FIELD)
    private User user;

    @ManyToOne
    @JoinColumn(name = Constants.COMPANY_ID_FIELD, referencedColumnName = Constants.ID_REFERENCE_FIELD)
    private Company company;

    @ManyToOne
    @JoinColumn(name = Constants.ACCELERATION_ID_FIELD, referencedColumnName = Constants.ID_REFERENCE_FIELD)
    private Acceleration acceleration;
}
