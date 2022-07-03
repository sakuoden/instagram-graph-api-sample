package sample.infrastructure.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Component;

@Component
public class LoginContext {
    OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    public String accessToken() {
        DefaultOAuth2User ログインユーザー = (DefaultOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // https://spring.pleiades.io/spring-security/site/docs/5.3.13.RELEASE/reference/html5/#oauth2Client-authorized-repo-service
        OAuth2AuthorizedClient ログインクライアント = oAuth2AuthorizedClientService.loadAuthorizedClient("facebook", ログインユーザー.getName());

        return ログインクライアント.getAccessToken().getTokenValue();
    }

    LoginContext(OAuth2AuthorizedClientService oAuth2AuthorizedClientService) {
        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    }
}
