/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.service;

import com.wadpam.donor.dao.DDonorDaoBean;
import com.wadpam.donor.domain.DDonor;
import com.wadpam.gaelic.crud.MardaoCrudService;
import net.sf.mardao.core.dao.Dao;

/**
 *
 * @author sosandstrom
 */
public class DonorService extends MardaoCrudService<DDonor, Long, Dao<DDonor, Long>> {

    public DonorService() {
        super(DDonor.class, Long.class, DDonorDaoBean.class);
    }

}
