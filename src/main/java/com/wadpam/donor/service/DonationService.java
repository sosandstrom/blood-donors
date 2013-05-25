/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.service;

import com.wadpam.donor.dao.DDonationDaoBean;
import com.wadpam.donor.domain.DDonation;
import com.wadpam.gaelic.crud.MardaoCrudService;
import net.sf.mardao.core.dao.Dao;

/**
 *
 * @author sosandstrom
 */
public class DonationService extends MardaoCrudService<DDonation, Long, Dao<DDonation, Long>> {

    public DonationService() {
        super(DDonation.class, Long.class, DDonationDaoBean.class);
    }

}
