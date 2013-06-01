/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.web;

import com.wadpam.donor.domain.DProfile;
import com.wadpam.donor.json.JProfile;
import com.wadpam.gaelic.crud.CrudService;
import com.wadpam.gaelic.oauth.web.UserConverter;
import com.wadpam.gaelic.tree.CrudLeaf;

/**
 *
 * @author sosandstrom
 */
public class ProfileLeaf extends CrudLeaf<JProfile, DProfile, Long, CrudService<DProfile, Long>> {
    
    public static final ProfileConverter CONVERTER = new ProfileConverter();

    public ProfileLeaf() {
        super(DProfile.class, Long.class, JProfile.class);
        setConverter(CONVERTER);
    }
    
    public static class ProfileConverter extends UserConverter<JProfile, DProfile> {

        public ProfileConverter() {
            super(JProfile.class, DProfile.class);
        }

        @Override
        public void convertDomain(DProfile from, JProfile to) {
            super.convertDomain(from, to);
            to.setPhoneNumber(from.getPhoneNumber());
            to.setAb0(from.getAb0());
        }

        @Override
        public void convertJson(JProfile from, DProfile to) {
            super.convertJson(from, to);
            to.setPhoneNumber(from.getPhoneNumber());
            to.setAb0(from.getAb0());
        }
        
    }
}
