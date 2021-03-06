/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.donor.config;

import com.wadpam.donor.service.BloodRegistryService;
import com.wadpam.donor.service.DonationService;
import com.wadpam.donor.service.ProfileService;
import com.wadpam.donor.web.DonationLeaf;
import com.wadpam.donor.web.ProfileLeaf;
import com.wadpam.donor.web.UserDetailsLeaf;
import com.wadpam.gaelic.GaelicConfig;
import com.wadpam.gaelic.GaelicServlet;
import com.wadpam.gaelic.Node;
import com.wadpam.gaelic.oauth.dao.DConnectionDao;
import com.wadpam.gaelic.oauth.service.ConnectionServiceImpl;
import com.wadpam.gaelic.oauth.service.OAuth2ServiceImpl;
import com.wadpam.gaelic.oauth.web.ConnectionConverter;
import com.wadpam.gaelic.oauth.web.OAuth2Interceptor;
import com.wadpam.gaelic.oauth.web.OAuth2Leaf;
import com.wadpam.gaelic.security.DomainSecurityInterceptor;
import com.wadpam.gaelic.security.SecurityConfig;
import com.wadpam.gaelic.service.AppDomainService;
import com.wadpam.gaelic.tree.AppDomainLeaf;
import com.wadpam.gaelic.tree.DomainNamespaceInterceptor;
import com.wadpam.gaelic.tree.Interceptor;
import com.wadpam.gaelic.web.MardaoPrincipalInterceptor;
import java.util.Collection;
import java.util.Map;
import javax.servlet.ServletConfig;

/**
 *
 * @author sosandstrom
 */
public class AppConfig implements GaelicConfig, SecurityConfig {

    @Override
    public Node init(GaelicServlet gaelicServlet, ServletConfig servletConfig) {

        // conventional services
        ConnectionServiceImpl connectionService = new ConnectionServiceImpl();
        DConnectionDao connectionDao = connectionService.getDao();
        
        ProfileService profileService = new ProfileService();
        ProfileLeaf profileLeaf = new ProfileLeaf();
        
        OAuth2ServiceImpl oauth2Service = new OAuth2ServiceImpl();
        oauth2Service.setConnectionDao(connectionDao);
        oauth2Service.setOauth2UserService(profileService);
        
        AppDomainService appDomainService = new AppDomainService();
        AppDomainLeaf appDomainLeaf = new AppDomainLeaf();
        
        ConnectionConverter connectionConverter = new ConnectionConverter(profileService.getDao());
        
        OAuth2Leaf oauth2Leaf = new OAuth2Leaf();
        oauth2Leaf.setService(oauth2Service);
        
        // Interceptors
        DomainSecurityInterceptor basicInterceptor = null; // new DomainSecurityInterceptor();
//        basicInterceptor.setSecurityDetailsService(appDomainService);
        
        DomainNamespaceInterceptor domainNamespaceInterceptor = new DomainNamespaceInterceptor();
        
        OAuth2Interceptor oauth2Interceptor = new OAuth2Interceptor();
        oauth2Interceptor.setConnectionService(connectionService);
        oauth2Interceptor.setOauth2Service(oauth2Service);
        
        initSecurity(basicInterceptor, oauth2Interceptor);
        BUILDER.root()
//                .interceptor("api", basicInterceptor)
                .interceptor("api", domainNamespaceInterceptor)
                .interceptor("api", oauth2Interceptor)
                .interceptedPath("api", new MardaoPrincipalInterceptor())
                    .path(Node.PATH_DOMAIN)
                        .path("_admin")
                            .path("domain")
                                .crud("v10", appDomainLeaf, appDomainService)
                        .from("_admin")
                            .path("profile")
                                .crud("v10", profileLeaf, profileService)
                    .from(Node.PATH_DOMAIN)
                        .path("federated")
                            .add("v11", oauth2Leaf);
        
        // Application Resources
        DonationService donationService = new DonationService();
        DonationLeaf donationLeaf = new DonationLeaf();
        
        BloodRegistryService registryService = new BloodRegistryService();
        registryService.setProfileService(profileService);
        UserDetailsLeaf userDetailsLeaf = new UserDetailsLeaf();
        
                BUILDER.from("_admin")
                            .path("donation")
                                .crud("v10", donationLeaf, donationService);

                BUILDER.from(Node.PATH_DOMAIN)
                        .path("details")
                            .crud("v10", userDetailsLeaf, registryService);
                
        
        return BUILDER.build();
    }

    private void initSecurity(Interceptor basicInterceptor, OAuth2Interceptor oauth2Interceptor) {
        Collection<Map.Entry<String, Collection<String>>> oauth2Whitelist = 
                WHITELIST_BUILDER.with("\\A/api/[^/]+/federated/v1.\\z", GET, POST)
                    .build();
        
        oauth2Interceptor.setWhitelistedMethods(oauth2Whitelist);
    }

}
