/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.json;

import com.wadpam.gaelic.json.JBaseObject;

/**
 *
 * @author sosandstrom
 */
public class JDonor extends JBaseObject {

    private Long userId;

    private String phoneNumber;
    
    private String ab0;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAb0() {
        return ab0;
    }

    public void setAb0(String ab0) {
        this.ab0 = ab0;
    }

    
}
