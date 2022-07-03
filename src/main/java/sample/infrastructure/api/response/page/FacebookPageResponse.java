package sample.infrastructure.api.response.page;

public record FacebookPageResponse(
    InstagramBusinessAccountResponse instagram_business_account,
    String id
) {
    public String instagramBusinessAccountId() {
        return instagram_business_account.id();
    }
}
