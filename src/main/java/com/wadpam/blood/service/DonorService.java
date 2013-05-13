/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.blood.service;

import com.wadpam.blood.dao.DDonorDaoBean;
import com.wadpam.blood.domain.DDonor;
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
