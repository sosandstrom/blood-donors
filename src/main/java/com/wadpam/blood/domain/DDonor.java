/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.blood.domain;

import com.wadpam.gaelic.oauth.domain.DOAuth2User;
import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 *
 * @author sosandstrom
 */
@Entity
public class DDonor extends DOAuth2User {

    @Basic
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
