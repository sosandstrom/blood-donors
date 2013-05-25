/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import net.sf.mardao.core.Parent;
import net.sf.mardao.core.domain.AbstractLongEntity;

/**
 *
 * @author sosandstrom
 */
@Entity
public class DDonation extends AbstractLongEntity {
    
    @Parent(kind = "DOAuth2User")
    private Object userKey;

    @Basic
    private String comment;
    
    @Basic
    private Date donationDate;

    @Basic
    private Short hb;

    public Object getUserKey() {
        return userKey;
    }

    public void setUserKey(Object userKey) {
        this.userKey = userKey;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public Short getHb() {
        return hb;
    }

    public void setHb(Short hb) {
        this.hb = hb;
    }

}
