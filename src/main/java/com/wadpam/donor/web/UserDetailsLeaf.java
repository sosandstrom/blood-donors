/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.web;

import com.wadpam.donor.json.JUserDetails;
import com.wadpam.donor.service.BloodRegistryService;
import com.wadpam.gaelic.converter.NoConverter;
import com.wadpam.gaelic.tree.CrudLeaf;

/**
 *
 * @author sosandstrom
 */
public class UserDetailsLeaf extends CrudLeaf<JUserDetails, JUserDetails, Long, BloodRegistryService> {
    
    protected static final NoConverter NO_CONVERTER = new NoConverter(JUserDetails.class);
    
    public UserDetailsLeaf() {
        super(JUserDetails.class, Long.class, JUserDetails.class);
        this.converter = NO_CONVERTER;
    }
    
}
