/*
 * INSERT COPYRIGHT HERE
 */

package com.wadpam.blood.config;

import com.wadpam.blood.service.DonorService;
import com.wadpam.blood.web.DonorLeaf;
import com.wadpam.gaelic.GaelicConfig;
import com.wadpam.gaelic.GaelicServlet;
import com.wadpam.gaelic.Node;
import com.wadpam.gaelic.oauth.dao.DConnectionDao;
import com.wadpam.gaelic.oauth.dao.DConnectionDaoBean;
import com.wadpam.gaelic.oauth.dao.DOAuth2UserDao;
import com.wadpam.gaelic.oauth.dao.DOAuth2UserDaoBean;
import com.wadpam.gaelic.oauth.service.ConnectionServiceImpl;
import com.wadpam.gaelic.oauth.service.OAuth2ServiceImpl;
import com.wadpam.gaelic.oauth.service.OAuth2UserServiceImpl;
import com.wadpam.gaelic.oauth.web.ConnectionConverter;
import com.wadpam.gaelic.oauth.web.OAuth2Interceptor;
import com.wadpam.gaelic.oauth.web.OAuth2Leaf;
import com.wadpam.gaelic.security.SecurityConfig;
import com.wadpam.gaelic.tree.Interceptor;
import com.wadpam.gaelic.tree.InterceptorAdapter;
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
        // DAO beans
        DConnectionDao connectionDao = new DConnectionDaoBean();
        DOAuth2UserDao userDao = new DOAuth2UserDaoBean();
        
        // services
        ConnectionServiceImpl connectionService = new ConnectionServiceImpl();
        connectionService.setDao(connectionDao);
        
        OAuth2UserServiceImpl userService = new OAuth2UserServiceImpl();
        userService.setDao(userDao);
        
        OAuth2ServiceImpl oauth2Service = new OAuth2ServiceImpl();
        oauth2Service.setConnectionDao(connectionDao);
        oauth2Service.setOauth2UserService(userService);
        
        // Converters
        ConnectionConverter connectionConverter = new ConnectionConverter(userDao);
        
        // Resources
        DonorService donorService = new DonorService();
        DonorLeaf donorLeaf = new DonorLeaf();
        donorLeaf.setService(donorService);
        
        OAuth2Leaf oauth2Leaf = new OAuth2Leaf();
        oauth2Leaf.setService(oauth2Service);
        
        // Interceptors
        Interceptor basicInterceptor = new InterceptorAdapter();
//                DomainSecurityInterceptor basicInterceptor = new DomainSecurityInterceptor();
        OAuth2Interceptor oauth2Interceptor = new OAuth2Interceptor();
        oauth2Interceptor.setConnectionService(connectionService);
        oauth2Interceptor.setOauth2Service(oauth2Service);
        
        BUILDER.root()
                .interceptor("api", basicInterceptor)
                .interceptedPath("api", oauth2Interceptor)
                    .path(Node.PATH_DOMAIN)
                        .path("_admin")
                            .crud("donor", donorLeaf, donorService);
        
        BUILDER.from(Node.PATH_DOMAIN)
                        .path("federated")
                            .add("v11", oauth2Leaf);
        
        initSecurity(basicInterceptor, oauth2Interceptor);
        
        return BUILDER.build();
    }

    private void initSecurity(Interceptor basicInterceptor, OAuth2Interceptor oauth2Interceptor) {
        Collection<Map.Entry<String, Collection<String>>> oauth2Whitelist = 
                WHITELIST_BUILDER.with("\\A/api/[^/]+/federated/v1.\\z", GET, POST)
                    .build();
        
        oauth2Interceptor.setWhitelistedMethods(oauth2Whitelist);
    }

}
