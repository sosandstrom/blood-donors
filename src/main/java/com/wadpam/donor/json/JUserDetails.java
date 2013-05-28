/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.json;

import com.wadpam.gaelic.oauth.json.JOAuth2User;
import java.util.Date;

/**
 * Inherited Audit fields are related to OAuth2User.
 * @author sosandstrom
 */
public class JUserDetails extends JOAuth2User {

    private String donorCreatedBy;
    private Date donorCreatedDate;
    private String phoneNumber;
    private String ab0;
    private Integer donationCount;
    private JDonation lastDonation;

    public String getDonorCreatedBy() {
        return donorCreatedBy;
    }

    public void setDonorCreatedBy(String donorCreatedBy) {
        this.donorCreatedBy = donorCreatedBy;
    }

    public Date getDonorCreatedDate() {
        return donorCreatedDate;
    }

    public void setDonorCreatedDate(Date donorCreatedDate) {
        this.donorCreatedDate = donorCreatedDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAb0() {
        return ab0;
    }

    public void setAb0(String ab0) {
        this.ab0 = ab0;
    }

    public Integer getDonationCount() {
        return donationCount;
    }

    public void setDonationCount(Integer donationCount) {
        this.donationCount = donationCount;
    }

    public JDonation getLastDonation() {
        return lastDonation;
    }

    public void setLastDonation(JDonation lastDonation) {
        this.lastDonation = lastDonation;
    }
    
}
