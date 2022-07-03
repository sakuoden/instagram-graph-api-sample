package sample.infrastructure.api.response.media;

import java.util.List;

public record MediasResponse(
    List<MediaResponse> data
) {
}
