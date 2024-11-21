package com.sopt.agoda.room.controller.dto.res;

import java.util.List;

public record HotelRoomInfo(
        Long roomId,
        String roomName,
        Number spaceSize,
        String bedType,
        Number bedCount,
        String bathInfo,
        Number maxCapacity,
        List<HotelRoomImage> roomImages
) {
    public static HotelRoomInfo of(
            final Long roomId, final String roomName, final Number spaceSize,
            final String bedType, final Number bedCount, final String bathInfo,
            final Number maxCapacity, final List<HotelRoomImage> roomImages
    ) {
        return new Builder()
                .roomId(roomId)
                .roomName(roomName)
                .spaceSize(spaceSize)
                .bedType(bedType)
                .bedCount(bedCount)
                .bathInfo(bathInfo)
                .maxCapacity(maxCapacity)
                .roomImages(roomImages)
                .build();
    }

    private static class Builder {
        private Long roomId;
        private String roomName;
        private Number spaceSize;
        private String bedType;
        private Number bedCount;
        private String bathInfo;
        private Number maxCapacity;
        private List<HotelRoomImage> roomImages;

        private Builder roomId(final Long roomId) {
            this.roomId = roomId;
            return this;
        }

        private Builder roomName(final String roomName) {
            this.roomName = roomName;
            return this;
        }

        private Builder spaceSize(final Number spaceSize) {
            this.spaceSize = spaceSize;
            return this;
        }

        private Builder bedType(final String bedType) {
            this.bedType = bedType;
            return this;
        }

        private Builder bedCount(final Number bedCount) {
            this.bedCount = bedCount;
            return this;
        }

        private Builder bathInfo(final String bathInfo) {
            this.bathInfo = bathInfo;
            return this;
        }

        private Builder maxCapacity(final Number maxCapacity) {
            this.maxCapacity = maxCapacity;
            return this;
        }

        private Builder roomImages(final List<HotelRoomImage> roomImages) {
            this.roomImages = roomImages;
            return this;
        }

        private HotelRoomInfo build() {
            return new HotelRoomInfo(roomId, roomName, spaceSize, bedType, bedCount, bathInfo, maxCapacity, roomImages);
        }
    }
}
