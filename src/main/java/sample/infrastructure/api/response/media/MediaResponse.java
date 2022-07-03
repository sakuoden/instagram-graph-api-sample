package sample.infrastructure.api.response.media;

public record MediaResponse(
    String id,
    String media_url,
    String caption
) {
}
