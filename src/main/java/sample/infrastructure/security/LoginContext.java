package sample.infrastructure.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Component;

@Component
public class LoginContext {
    public String accessToken() {
        DefaultOAuth2User ログインユーザー = (DefaultOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        OAuth2AuthorizedClient ログインクライアント = oAuth2AuthorizedClientService.loadAuthorizedClient("facebook", ログインユーザー.getName());

        return ログインクライアント.getAccessToken().getTokenValue();
    }

    OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
    LoginContext(OAuth2AuthorizedClientService oAuth2AuthorizedClientService) {
        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    }
}
