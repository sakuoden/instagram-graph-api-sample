package sample.application;

import org.springframework.stereotype.Service;
import sample.infrastructure.api.InstagramGraphApiClient;
import sample.infrastructure.api.response.media.MediasResponse;
import sample.infrastructure.api.response.page.FacebookPageResponse;
import sample.infrastructure.api.response.user.UserAccountsResponse;

@Service
public class InstagramService {
    InstagramGraphApiClient instagramGraphApiClient;

    public MediasResponse medias() {
        UserAccountsResponse userAccounts = instagramGraphApiClient.userAccounts();
        FacebookPageResponse facebookPage = instagramGraphApiClient.facebookPage(userAccounts.facebookPageId());

        return instagramGraphApiClient.medias(facebookPage.instagramBusinessAccountId());
    }

    InstagramService(InstagramGraphApiClient instagramGraphApiClient) {
        this.instagramGraphApiClient = instagramGraphApiClient;
    }
}
