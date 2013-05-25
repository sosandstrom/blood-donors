/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import net.sf.mardao.core.Parent;
import net.sf.mardao.core.domain.AbstractLongEntity;

/**
 *
 * @author sosandstrom
 */
@Entity
public class DDonor extends AbstractLongEntity {
    
    @Parent(kind = "DOAuth2User")
    private Object userKey;

    @Basic
    private String phoneNumber;
    
    @Basic
    private String ab0;

    public Object getUserKey() {
        return userKey;
    }

    public void setUserKey(Object userKey) {
        this.userKey = userKey;
    }

    public String getAb0() {
        return ab0;
    }

    public void setAb0(String ab0) {
        this.ab0 = ab0;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
