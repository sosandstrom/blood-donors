package com.wadpam.donor.dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import net.sf.mardao.core.CursorPage;
import net.sf.mardao.core.dao.Dao;
import com.wadpam.donor.domain.DDonor;
import net.sf.mardao.core.geo.DLocation;

/**
 * DAO interface with finder methods for DDonor entities.
 *
 * Generated on 2013-05-25T17:35:10.015+0700.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public interface GeneratedDDonorDao extends Dao<DDonor, java.lang.Long> {

	/** Column name for primary key attribute is "id" */
	static final String COLUMN_NAME_ID = "id";

	/** Column name for parent userKey is "userKey" */
	static final String COLUMN_NAME_USERKEY = "userKey";


	/** Column name for field ab0 is "ab0" */
	static final String COLUMN_NAME_AB0 = "ab0";
	/** Column name for field createdBy is "createdBy" */
	static final String COLUMN_NAME_CREATEDBY = "createdBy";
	/** Column name for field createdDate is "createdDate" */
	static final String COLUMN_NAME_CREATEDDATE = "createdDate";
	/** Column name for field phoneNumber is "phoneNumber" */
	static final String COLUMN_NAME_PHONENUMBER = "phoneNumber";
	/** Column name for field updatedBy is "updatedBy" */
	static final String COLUMN_NAME_UPDATEDBY = "updatedBy";
	/** Column name for field updatedDate is "updatedDate" */
	static final String COLUMN_NAME_UPDATEDDATE = "updatedDate";

	/** The list of attribute names */
	static final List<String> COLUMN_NAMES = Arrays.asList(		COLUMN_NAME_AB0,
		COLUMN_NAME_CREATEDBY,
		COLUMN_NAME_CREATEDDATE,
		COLUMN_NAME_PHONENUMBER,
		COLUMN_NAME_UPDATEDBY,
		COLUMN_NAME_UPDATEDDATE);
	/** The list of Basic attribute names */
	static final List<String> BASIC_NAMES = Arrays.asList(		COLUMN_NAME_AB0,
		COLUMN_NAME_CREATEDBY,
		COLUMN_NAME_CREATEDDATE,
		COLUMN_NAME_PHONENUMBER,
		COLUMN_NAME_UPDATEDBY,
		COLUMN_NAME_UPDATEDDATE);
	/** The list of attribute names */
	static final List<String> MANY_TO_ONE_NAMES = Arrays.asList();


	// ----------------------- parent finder -------------------------------
	/**
	 * query-by method for parent field userKey
	 * @param userKey the specified attribute
	 * @return an Iterable of DDonors with the specified parent
	 */
	Iterable<DDonor> queryByUserKey(Object userKey);
		
	/**
	 * query-keys-by method for parent field userKey
	 * @param userKey the specified attribute
	 * @return an Iterable of DDonors with the specified parent
	 */
	Iterable<java.lang.Long> queryKeysByUserKey(Object userKey);

	/**
	 * query-page-by method for parent field userKey
	 * @param userKey the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonors for the specified userKey (parent)
	 */
	CursorPage<DDonor, java.lang.Long> queryPageByUserKey(java.lang.Object userKey,
            int pageSize, String cursorString);

	// ----------------------- field finders -------------------------------
	/**
	 * query-by method for field ab0
	 * @param ab0 the specified attribute
	 * @return an Iterable of DDonors for the specified ab0
	 */
	Iterable<DDonor> queryByAb0(java.lang.String ab0);
		
	/**
	 * query-keys-by method for field ab0
	 * @param ab0 the specified attribute
	 * @return an Iterable of DDonors for the specified ab0
	 */
	Iterable<java.lang.Long> queryKeysByAb0(java.lang.String ab0);

	/**
	 * query-page-by method for field ab0
	 * @param ab0 the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonors for the specified ab0
	 */
	CursorPage<DDonor, java.lang.Long> queryPageByAb0(java.lang.String ab0,
            int pageSize, String cursorString);


	/**
	 * query-by method for field createdBy
	 * @param createdBy the specified attribute
	 * @return an Iterable of DDonors for the specified createdBy
	 */
	Iterable<DDonor> queryByCreatedBy(java.lang.String createdBy);
		
	/**
	 * query-keys-by method for field createdBy
	 * @param createdBy the specified attribute
	 * @return an Iterable of DDonors for the specified createdBy
	 */
	Iterable<java.lang.Long> queryKeysByCreatedBy(java.lang.String createdBy);

	/**
	 * query-page-by method for field createdBy
	 * @param createdBy the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonors for the specified createdBy
	 */
	CursorPage<DDonor, java.lang.Long> queryPageByCreatedBy(java.lang.String createdBy,
            int pageSize, String cursorString);


	/**
	 * query-by method for field createdDate
	 * @param createdDate the specified attribute
	 * @return an Iterable of DDonors for the specified createdDate
	 */
	Iterable<DDonor> queryByCreatedDate(java.util.Date createdDate);
		
	/**
	 * query-keys-by method for field createdDate
	 * @param createdDate the specified attribute
	 * @return an Iterable of DDonors for the specified createdDate
	 */
	Iterable<java.lang.Long> queryKeysByCreatedDate(java.util.Date createdDate);

	/**
	 * query-page-by method for field createdDate
	 * @param createdDate the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonors for the specified createdDate
	 */
	CursorPage<DDonor, java.lang.Long> queryPageByCreatedDate(java.util.Date createdDate,
            int pageSize, String cursorString);


	/**
	 * query-by method for field phoneNumber
	 * @param phoneNumber the specified attribute
	 * @return an Iterable of DDonors for the specified phoneNumber
	 */
	Iterable<DDonor> queryByPhoneNumber(java.lang.String phoneNumber);
		
	/**
	 * query-keys-by method for field phoneNumber
	 * @param phoneNumber the specified attribute
	 * @return an Iterable of DDonors for the specified phoneNumber
	 */
	Iterable<java.lang.Long> queryKeysByPhoneNumber(java.lang.String phoneNumber);

	/**
	 * query-page-by method for field phoneNumber
	 * @param phoneNumber the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonors for the specified phoneNumber
	 */
	CursorPage<DDonor, java.lang.Long> queryPageByPhoneNumber(java.lang.String phoneNumber,
            int pageSize, String cursorString);


	/**
	 * query-by method for field updatedBy
	 * @param updatedBy the specified attribute
	 * @return an Iterable of DDonors for the specified updatedBy
	 */
	Iterable<DDonor> queryByUpdatedBy(java.lang.String updatedBy);
		
	/**
	 * query-keys-by method for field updatedBy
	 * @param updatedBy the specified attribute
	 * @return an Iterable of DDonors for the specified updatedBy
	 */
	Iterable<java.lang.Long> queryKeysByUpdatedBy(java.lang.String updatedBy);

	/**
	 * query-page-by method for field updatedBy
	 * @param updatedBy the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonors for the specified updatedBy
	 */
	CursorPage<DDonor, java.lang.Long> queryPageByUpdatedBy(java.lang.String updatedBy,
            int pageSize, String cursorString);


	/**
	 * query-by method for field updatedDate
	 * @param updatedDate the specified attribute
	 * @return an Iterable of DDonors for the specified updatedDate
	 */
	Iterable<DDonor> queryByUpdatedDate(java.util.Date updatedDate);
		
	/**
	 * query-keys-by method for field updatedDate
	 * @param updatedDate the specified attribute
	 * @return an Iterable of DDonors for the specified updatedDate
	 */
	Iterable<java.lang.Long> queryKeysByUpdatedDate(java.util.Date updatedDate);

	/**
	 * query-page-by method for field updatedDate
	 * @param updatedDate the specified attribute
         * @param pageSize the number of domain entities in the page
         * @param cursorString non-null if get next page
	 * @return a Page of DDonors for the specified updatedDate
	 */
	CursorPage<DDonor, java.lang.Long> queryPageByUpdatedDate(java.util.Date updatedDate,
            int pageSize, String cursorString);


		  
	// ----------------------- one-to-one finders -------------------------

	// ----------------------- many-to-one finders -------------------------
	
	// ----------------------- many-to-many finders -------------------------

	// ----------------------- uniqueFields finders -------------------------
	
	
	// ----------------------- populate / persist method -------------------------

	/**
	 * Persist an entity given all attributes
	 */
	DDonor persist(Object userKey,  	
		java.lang.Long id, 
		java.lang.String ab0, 
		java.lang.String phoneNumber);	

}
