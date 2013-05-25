package com.wadpam.donor.dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import net.sf.mardao.core.CursorPage;
import net.sf.mardao.core.dao.Dao;
import com.wadpam.donor.domain.DDonation;
import net.sf.mardao.core.geo.DLocation;

/**
 * DAO interface with finder methods for DDonation entities.
 *
 * Generated on 2013-05-25T17:35:10.015+0700.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public interface GeneratedDDonationDao extends Dao<DDonation, java.lang.Long> {

	/** Column name for primary key attribute is "id" */
	static final String COLUMN_NAME_ID = "id";

	/** Column name for parent userKey is "userKey" */
	static final String COLUMN_NAME_USERKEY = "userKey";


	/** Column name for field comment is "comment" */
	static final String COLUMN_NAME_COMMENT = "comment";
	/** Column name for field createdBy is "createdBy" */
	static final String COLUMN_NAME_CREATEDBY = "createdBy";
	/** Column name for field createdDate is "createdDate" */
	static final String COLUMN_NAME_CREATEDDATE = "createdDate";
	/** Column name for field donationDate is "donationDate" */
	static final String COLUMN_NAME_DONATIONDATE = "donationDate";
	/** Column name for field hb is "hb" */
	static final String COLUMN_NAME_HB = "hb";
	/** Column name for field updatedBy is "updatedBy" */
	static final String COLUMN_NAME_UPDATEDBY = "updatedBy";
	/** Column name for field updatedDate is "updatedDate" */
	static final String COLUMN_NAME_UPDATEDDATE = "updatedDate";

	/** The list of attribute names */
	static final List<String> COLUMN_NAMES = Arrays.asList(		COLUMN_NAME_COMMENT,
		COLUMN_NAME_CREATEDBY,
		COLUMN_NAME_CREATEDDATE,
		COLUMN_NAME_DONATIONDATE,
		COLUMN_NAME_HB,
		COLUMN_NAME_UPDATEDBY,
		COLUMN_NAME_UPDATEDDATE);
	/** The list of Basic attribute names */
	static final List<String> BASIC_NAMES = Arrays.asList(		COLUMN_NAME_COMMENT,
		COLUMN_NAME_CREATEDBY,
		COLUMN_NAME_CREATEDDATE,
		COLUMN_NAME_DONATIONDATE,
		COLUMN_NAME_HB,
		COLUMN_NAME_UPDATEDBY,
		COLUMN_NAME_UPDATEDDATE);
	/** The list of attribute names */
	static final List<String> MANY_TO_ONE_NAMES = Arrays.asList();


	// ----------------------- parent finder -------------------------------
	/**
	 * query-by method for parent field userKey
	 * @param userKey the specified attribute
	 * @return an Iterable of DDonations with the specified parent
	 */
	Iterable<DDonation> queryByUserKey(Object userKey);
		
	/**
	 * query-keys-by method for parent field userKey
	 * @param userKey the specified attribute
	 * @return an Iterable of DDonations with the specified parent
	 */
	Iterable<java.lang.Long> queryKeysByUserKey(Object userKey);

	/**
	 * query-page-by method for parent field userKey
	 * @param userKey the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonations for the specified userKey (parent)
	 */
	CursorPage<DDonation, java.lang.Long> queryPageByUserKey(java.lang.Object userKey,
            int pageSize, String cursorString);

	// ----------------------- field finders -------------------------------
	/**
	 * query-by method for field comment
	 * @param comment the specified attribute
	 * @return an Iterable of DDonations for the specified comment
	 */
	Iterable<DDonation> queryByComment(java.lang.String comment);
		
	/**
	 * query-keys-by method for field comment
	 * @param comment the specified attribute
	 * @return an Iterable of DDonations for the specified comment
	 */
	Iterable<java.lang.Long> queryKeysByComment(java.lang.String comment);

	/**
	 * query-page-by method for field comment
	 * @param comment the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonations for the specified comment
	 */
	CursorPage<DDonation, java.lang.Long> queryPageByComment(java.lang.String comment,
            int pageSize, String cursorString);


	/**
	 * query-by method for field createdBy
	 * @param createdBy the specified attribute
	 * @return an Iterable of DDonations for the specified createdBy
	 */
	Iterable<DDonation> queryByCreatedBy(java.lang.String createdBy);
		
	/**
	 * query-keys-by method for field createdBy
	 * @param createdBy the specified attribute
	 * @return an Iterable of DDonations for the specified createdBy
	 */
	Iterable<java.lang.Long> queryKeysByCreatedBy(java.lang.String createdBy);

	/**
	 * query-page-by method for field createdBy
	 * @param createdBy the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonations for the specified createdBy
	 */
	CursorPage<DDonation, java.lang.Long> queryPageByCreatedBy(java.lang.String createdBy,
            int pageSize, String cursorString);


	/**
	 * query-by method for field createdDate
	 * @param createdDate the specified attribute
	 * @return an Iterable of DDonations for the specified createdDate
	 */
	Iterable<DDonation> queryByCreatedDate(java.util.Date createdDate);
		
	/**
	 * query-keys-by method for field createdDate
	 * @param createdDate the specified attribute
	 * @return an Iterable of DDonations for the specified createdDate
	 */
	Iterable<java.lang.Long> queryKeysByCreatedDate(java.util.Date createdDate);

	/**
	 * query-page-by method for field createdDate
	 * @param createdDate the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonations for the specified createdDate
	 */
	CursorPage<DDonation, java.lang.Long> queryPageByCreatedDate(java.util.Date createdDate,
            int pageSize, String cursorString);


	/**
	 * query-by method for field donationDate
	 * @param donationDate the specified attribute
	 * @return an Iterable of DDonations for the specified donationDate
	 */
	Iterable<DDonation> queryByDonationDate(java.util.Date donationDate);
		
	/**
	 * query-keys-by method for field donationDate
	 * @param donationDate the specified attribute
	 * @return an Iterable of DDonations for the specified donationDate
	 */
	Iterable<java.lang.Long> queryKeysByDonationDate(java.util.Date donationDate);

	/**
	 * query-page-by method for field donationDate
	 * @param donationDate the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonations for the specified donationDate
	 */
	CursorPage<DDonation, java.lang.Long> queryPageByDonationDate(java.util.Date donationDate,
            int pageSize, String cursorString);


	/**
	 * query-by method for field hb
	 * @param hb the specified attribute
	 * @return an Iterable of DDonations for the specified hb
	 */
	Iterable<DDonation> queryByHb(java.lang.Short hb);
		
	/**
	 * query-keys-by method for field hb
	 * @param hb the specified attribute
	 * @return an Iterable of DDonations for the specified hb
	 */
	Iterable<java.lang.Long> queryKeysByHb(java.lang.Short hb);

	/**
	 * query-page-by method for field hb
	 * @param hb the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonations for the specified hb
	 */
	CursorPage<DDonation, java.lang.Long> queryPageByHb(java.lang.Short hb,
            int pageSize, String cursorString);


	/**
	 * query-by method for field updatedBy
	 * @param updatedBy the specified attribute
	 * @return an Iterable of DDonations for the specified updatedBy
	 */
	Iterable<DDonation> queryByUpdatedBy(java.lang.String updatedBy);
		
	/**
	 * query-keys-by method for field updatedBy
	 * @param updatedBy the specified attribute
	 * @return an Iterable of DDonations for the specified updatedBy
	 */
	Iterable<java.lang.Long> queryKeysByUpdatedBy(java.lang.String updatedBy);

	/**
	 * query-page-by method for field updatedBy
	 * @param updatedBy the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonations for the specified updatedBy
	 */
	CursorPage<DDonation, java.lang.Long> queryPageByUpdatedBy(java.lang.String updatedBy,
            int pageSize, String cursorString);


	/**
	 * query-by method for field updatedDate
	 * @param updatedDate the specified attribute
	 * @return an Iterable of DDonations for the specified updatedDate
	 */
	Iterable<DDonation> queryByUpdatedDate(java.util.Date updatedDate);
		
	/**
	 * query-keys-by method for field updatedDate
	 * @param updatedDate the specified attribute
	 * @return an Iterable of DDonations for the specified updatedDate
	 */
	Iterable<java.lang.Long> queryKeysByUpdatedDate(java.util.Date updatedDate);

	/**
	 * query-page-by method for field updatedDate
	 * @param updatedDate the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonations for the specified updatedDate
	 */
	CursorPage<DDonation, java.lang.Long> queryPageByUpdatedDate(java.util.Date updatedDate,
            int pageSize, String cursorString);


		  
	// ----------------------- one-to-one finders -------------------------

	// ----------------------- many-to-one finders -------------------------
	
	// ----------------------- many-to-many finders -------------------------

	// ----------------------- uniqueFields finders -------------------------
	
	
	// ----------------------- populate / persist method -------------------------

	/**
	 * Persist an entity given all attributes
	 */
	DDonation persist(Object userKey,  	
		java.lang.Long id, 
		java.lang.String comment, 
		java.util.Date donationDate, 
		java.lang.Short hb);	

}
