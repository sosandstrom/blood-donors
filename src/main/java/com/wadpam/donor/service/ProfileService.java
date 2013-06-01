/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.service;

import com.wadpam.donor.dao.DProfileDao;
import com.wadpam.donor.dao.DProfileDaoBean;
import com.wadpam.donor.domain.DProfile;
import com.wadpam.gaelic.oauth.service.OAuth2UserServiceImpl;

/**
 *
 * @author sosandstrom
 */
public class ProfileService extends OAuth2UserServiceImpl<DProfile, DProfileDao> {

    public ProfileService() {
        super(DProfile.class, DProfileDaoBean.class);
    }

}
