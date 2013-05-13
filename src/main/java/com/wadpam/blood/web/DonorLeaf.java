/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.blood.web;

import com.wadpam.blood.domain.DDonor;
import com.wadpam.blood.json.JDonor;
import com.wadpam.gaelic.converter.LongConverter;
import com.wadpam.gaelic.crud.CrudService;
import com.wadpam.gaelic.tree.CrudLeaf;

/**
 *
 * @author sosandstrom
 */
public class DonorLeaf extends CrudLeaf<JDonor, DDonor, Long, CrudService<DDonor, Long>> {

    public DonorLeaf() {
        super(DDonor.class, Long.class, JDonor.class);
    }
    
    static class DonorConverter extends LongConverter<JDonor, DDonor> {

        public DonorConverter() {
            super(JDonor.class, DDonor.class);
        }

        @Override
        public void convertDomain(DDonor from, JDonor to) {
            super.convertDomain(from, to);
            to.setPhoneNumber(from.getPhoneNumber());
        }

        @Override
        public void convertJson(JDonor from, DDonor to) {
            super.convertJson(from, to);
            to.setPhoneNumber(from.getPhoneNumber());
        }
        
    }
}
