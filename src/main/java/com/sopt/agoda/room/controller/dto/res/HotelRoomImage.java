package com.sopt.agoda.room.controller.dto.res;

public record HotelRoomImage(
        Long roomImageId,
        String roomImageUrl
) {
    public static HotelRoomImage of(Long roomImageId, String roomImageUrl) {
        return new Builder()
                .roomImageId(roomImageId)
                .roomImageUrl(roomImageUrl)
                .build();
    }

    private static class Builder {
        private Long roomImageId;
        private String roomImageUrl;

        private Builder roomImageId(final Long roomImageId) {
            this.roomImageId = roomImageId;
            return this;
        }

        private Builder roomImageUrl(final String roomImageUrl) {
            this.roomImageUrl = roomImageUrl;
            return this;
        }

        private HotelRoomImage build() {
            return new HotelRoomImage(roomImageId, roomImageUrl);
        }
    }


}
