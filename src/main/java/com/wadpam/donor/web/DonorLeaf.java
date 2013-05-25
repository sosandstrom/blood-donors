/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.web;

import com.wadpam.donor.domain.DDonor;
import com.wadpam.donor.json.JDonor;
import com.wadpam.donor.service.DonorService;
import com.wadpam.gaelic.converter.LongConverter;
import com.wadpam.gaelic.tree.CrudLeaf;

/**
 *
 * @author sosandstrom
 */
public class DonorLeaf extends CrudLeaf<JDonor, DDonor, Long, DonorService> {
    
    static final DonorConverter CONVERTER = new DonorConverter();

    public DonorLeaf() {
        super(DDonor.class, Long.class, JDonor.class);
        setConverter(CONVERTER);
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
