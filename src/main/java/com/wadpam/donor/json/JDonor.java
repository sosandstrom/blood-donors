/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.json;

import com.wadpam.gaelic.oauth.json.JOAuth2User;

/**
 *
 * @author sosandstrom
 */
public class JDonor extends JOAuth2User {

    private Long userId;

    private String phoneNumber;
    
    private String ab0;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
}
