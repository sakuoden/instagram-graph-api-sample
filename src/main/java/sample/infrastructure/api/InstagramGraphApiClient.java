package sample.infrastructure.api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sample.infrastructure.api.response.media.MediasResponse;
import sample.infrastructure.api.response.page.FacebookPageResponse;
import sample.infrastructure.api.response.user.UserAccountsResponse;
import sample.infrastructure.security.LoginContext;

@Component
public class InstagramGraphApiClient {
    RestTemplate restTemplate;
    LoginContext loginContext;

    private String withAccessToken(String url) {
        return (url + "access_token=%s").formatted(loginContext.accessToken());
    }

    // https://developers.facebook.com/docs/graph-api/reference/user
    public UserAccountsResponse userAccounts() {
        return restTemplate.getForObject(withAccessToken("/me/accounts?"), UserAccountsResponse.class);
    }

    // https://developers.facebook.com/docs/graph-api/reference/page/
    public FacebookPageResponse facebookPage(String facebookPageId) {
        String url = "/%s?fields=instagram_business_account&".formatted(facebookPageId);
        return restTemplate.getForObject(withAccessToken(url), FacebookPageResponse.class);
    }

    // https://developers.facebook.com/docs/instagram-api/reference/ig-user/media
    public MediasResponse medias(String instagramBusinessAccountId) {
        String url = "/%s/media?fields=caption,media_url&".formatted(instagramBusinessAccountId);
        return restTemplate.getForObject(withAccessToken(url), MediasResponse.class);
    }

    InstagramGraphApiClient(RestTemplateBuilder restTemplateBuilder, LoginContext loginContext) {
        this.restTemplate = restTemplateBuilder
            .rootUri("https://graph.facebook.com/v14.0")
            .build();
        this.loginContext = loginContext;
    }
}
