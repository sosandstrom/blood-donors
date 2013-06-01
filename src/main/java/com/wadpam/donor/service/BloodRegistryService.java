/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.service;

import com.wadpam.donor.dao.DDonationDao;
import com.wadpam.donor.domain.DDonation;
import com.wadpam.donor.domain.DProfile;
import com.wadpam.donor.json.JUserDetails;
import com.wadpam.donor.web.DonationLeaf;
import com.wadpam.donor.web.ProfileLeaf;
import com.wadpam.gaelic.crud.CrudService;
import com.wadpam.gaelic.exception.NotFoundException;
import com.wadpam.gaelic.json.JCursorPage;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sosandstrom
 */
public class BloodRegistryService implements CrudService<JUserDetails, Long>{
    
    static final Logger LOG = LoggerFactory.getLogger(BloodRegistryService.class);
    
    private ProfileService profileService;
    private DDonationDao donationDao;
    
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
        final Object userKey = profileService.getDao().getPrimaryKey(null, userId);
        Map userDetails = profileService.getDao().queryByAncestorKey(userKey);
        if (userDetails.isEmpty()) {
            throw new NotFoundException();
        }
        
        Iterator<Entry> entries = userDetails.entrySet().iterator();
        final JUserDetails body = new JUserDetails();
        
        Entry entry;
        while (entries.hasNext()) {
            entry = entries.next();
            LOG.debug("merging {}", entry);
            if (entry.getValue() instanceof DProfile) {
                ProfileLeaf.CONVERTER.convertDomain((DProfile) entry.getValue(), body);
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
        Object userKey = profileService.getDao().getPrimaryKey(null, userId);
        DProfile profile = profileService.getDao().findByPrimaryKey(userId);
        
        profile.setDisplayName(domain.getDisplayName());
        profile.setEmail(domain.getEmail());
        profile.setPhoneNumber(domain.getPhoneNumber());
        profileService.update(profile);

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

    public void setDonationDao(DDonationDao donationDao) {
        this.donationDao = donationDao;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

}
