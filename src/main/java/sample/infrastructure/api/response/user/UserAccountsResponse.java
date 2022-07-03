package sample.infrastructure.api.response.user;

import java.util.List;

public record UserAccountsResponse(
    List<UserAccountResponse> data
) {
    public String facebookPageId() {
        UserAccountResponse userAccount = data.get(0);
        return userAccount.id();
    }
}
