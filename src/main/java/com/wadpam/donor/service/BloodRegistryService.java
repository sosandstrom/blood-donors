/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.service;

import com.wadpam.donor.dao.DDonationDao;
import com.wadpam.donor.dao.DDonorDao;
import com.wadpam.donor.domain.DDonation;
import com.wadpam.donor.domain.DDonor;
import com.wadpam.donor.json.JUserDetails;
import com.wadpam.donor.web.DonationLeaf;
import com.wadpam.gaelic.crud.CrudService;
import com.wadpam.gaelic.exception.NotFoundException;
import com.wadpam.gaelic.json.JCursorPage;
import com.wadpam.gaelic.oauth.dao.DOAuth2UserDao;
import com.wadpam.gaelic.oauth.domain.DOAuth2User;
import com.wadpam.gaelic.oauth.web.UserConverter;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sosandstrom
 */
public class BloodRegistryService implements CrudService<JUserDetails, Long>{
    
    static final Logger LOG = LoggerFactory.getLogger(BloodRegistryService.class);
    
    private DOAuth2UserDao userDao;
    private DDonorDao donorDao;
    private DDonationDao donationDao;
    
    private final UserConverter<JUserDetails, DOAuth2User> userConverter = new UserConverter(JUserDetails.class, DOAuth2User.class);

    protected void convertDonor(DDonor from, JUserDetails to) {
        to.setAb0(from.getAb0());
        to.setDonorCreatedBy(from.getCreatedBy());
        to.setDonorCreatedDate(from.getCreatedDate());
        to.setPhoneNumber(from.getPhoneNumber());
    }
    
    protected void convertDonation(DDonation from, JUserDetails to) {
        to.setDonationCount(1 + (null != to.getDonationCount() ? to.getDonationCount() : 0));
        if (null == to.getLastDonation() || 
                to.getLastDonation().getDonationDate() < from.getDonationDate().getTime()) {
            to.setLastDonation(DonationLeaf.CONVERTER.convertDomain(from));
        }
    }
    
    @Override
    public JUserDetails createDomain() {
        return new JUserDetails();
    }

    @Override
    public Long create(JUserDetails domain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String parentKeyString, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String parentKeyString, Long[] id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JUserDetails get(String parentKeyString, Long userId) {
        final Object userKey = userDao.getPrimaryKey(null, userId);
        Map userDetails = userDao.queryByAncestorKey(userKey);
        if (userDetails.isEmpty()) {
            throw new NotFoundException();
        }
        
        Iterator<Entry> entries = userDetails.entrySet().iterator();
        DOAuth2User dUser = (DOAuth2User) entries.next().getValue();
        JUserDetails body = userConverter.convertDomain(dUser);
        
        Entry entry;
        while (entries.hasNext()) {
            entry = entries.next();
            LOG.debug("merging {}", entry);
            if (entry.getValue() instanceof DDonor) {
                convertDonor((DDonor) entry.getValue(), body);
            }
            else if (entry.getValue() instanceof DDonation) {
                convertDonation((DDonation) entry.getValue(), body);
            }
        }
        
        return body;
    }

    @Override
    public Iterable<JUserDetails> getByPrimaryKeys(Collection<Long> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class getDaoClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<JUserDetails> getDomainClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<Long> getIdClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JCursorPage<JUserDetails> getPage(int pageSize, String cursorKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getSimpleKey(JUserDetails domain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSimpleKeyString(Object primaryKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getParentKeyString(JUserDetails domain) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrimaryKeyColumnName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class getPrimaryKeyColumnClass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Class> getTypeMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long update(JUserDetails domain) {
        final long userId = Long.parseLong(domain.getId());
        Object userKey = userDao.getPrimaryKey(null, userId);
        
        // async style
        Iterator<DDonor> donors = donorDao.queryByUserKey(userKey).iterator();
        DOAuth2User user = userDao.findByPrimaryKey(userId);
        
        user.setDisplayName(domain.getDisplayName());
        user.setEmail(domain.getEmail());
        userDao.update(user);

        DDonor donor = donors.hasNext() ? donors.next() : new DDonor();
        donor.setUserKey(userKey);
        donor.setPhoneNumber(domain.getPhoneNumber());
        donorDao.update(donor);
        
        return userId;
    }

    @Override
    public List<Long> upsert(Iterable<JUserDetails> domains) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JCursorPage<Long> whatsChanged(Date since, int pageSize, String cursorKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setUserDao(DOAuth2UserDao userDao) {
        this.userDao = userDao;
    }

    public void setDonorDao(DDonorDao donorDao) {
        this.donorDao = donorDao;
    }

    public void setDonationDao(DDonationDao donationDao) {
        this.donationDao = donationDao;
    }

}
