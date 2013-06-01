/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.web;

import com.wadpam.donor.domain.DDonation;
import com.wadpam.donor.domain.DProfile;
import com.wadpam.donor.json.JDonation;
import com.wadpam.donor.json.JProfile;
import com.wadpam.donor.service.DonationService;
import static com.wadpam.gaelic.converter.BaseConverter.toLong;
import com.wadpam.gaelic.converter.LongConverter;
import com.wadpam.gaelic.tree.CrudLeaf;

/**
 *
 * @author sosandstrom
 */
public class DonationLeaf extends CrudLeaf<JDonation, DDonation, Long, DonationService> {
    
    public static final DonationConverter CONVERTER = new DonationConverter();

    public DonationLeaf() {
        super(DDonation.class, Long.class, JDonation.class);
        setConverter(CONVERTER);
    }
    
    public static class DonationConverter extends LongConverter<JDonation, DDonation> {

        public DonationConverter() {
            super(JDonation.class, DDonation.class);
        }

        @Override
        public void convertDomain(DDonation from, JDonation to) {
            convertLongEntity(from, to);
            to.setComment(from.getComment());
            to.setDonationDate(toLong(from.getDonationDate()));
            to.setHb(from.getHb());
            // userId is populated by other converter
            // to.setUserId(from.getUserKey());
        }

        @Override
        public void convertJson(JDonation from, DDonation to) {
            convertJLong(from, to);
            to.setComment(from.getComment());
            to.setDonationDate(toDate(from.getDonationDate()));
            to.setHb(from.getHb());
            // userId is populated by other converter
            // to.setUserId(from.getUserKey());
        }
        
    }
}
