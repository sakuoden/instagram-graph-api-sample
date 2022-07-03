package sample.infrastructure.api.response.user;

public record UserAccountResponse(
    String access_token,
    String category,
    String name,
    String id
) {
}
