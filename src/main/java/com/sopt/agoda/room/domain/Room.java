package com.sopt.agoda.room.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", nullable = false)
    private Long id;

    @Column(name = "room_name", nullable = false)
    @NotNull(message = "방이름이 null이면 안됩니다")
    private String name;

    @Column(name = "space_size", nullable = false)
    @NotNull(message = "방 크기가 null이면 안됩니다.")
    @Min(value=0, message = "방 크기는 최소 0입니다. ")
    private int spaceSize;

    @Column(name = "bed_type", nullable = false)
    @NotNull(message = "침대 타입이 null이면 안됩니다.")
    private String bedType;

    @Column(name = "bed_count", nullable = false)
    @NotNull(message = "침대 개수가 null이면 안됩니다.")
    @Min(value = 0, message = "최소 침대 개수는 0개입니다")
    private int bedCount;

    @Column(name = "bath_info", nullable = false)
    @NotBlank(message = "욕실 정보가 null이면 안됩니다.")
    private String bathInfo;

    @Column(name = "max_capacity", nullable = false)
    @NotNull(message = "최대 수용인원이 null이면 안됩니다.")
    @Min(value = 1, message = "수용인원이 최소 1명은 되어야 합니다.")
    private int maxCapacity;

    @Column(name = "hotel_id", nullable = false)
    @NotNull(message = "호텔 아이디가 null이면 안됩니다.")
    private long hotelId;

    protected Room() {}

    private Room(final Builder builder) {
        this.name = builder.name;
        this.spaceSize = builder.spaceSize;
        this.bedType = builder.bedType;
        this.bedCount = builder.bedCount;
        this.bathInfo = builder.bathInfo;
        this.maxCapacity = builder.maxCapacity;
        this.hotelId = builder.hotelId;
    }

    public static Room create(final String name, final int spaceSize, final String bedType, final int bedCount,
                              final String bathInfo, final int maxCapacity, final long hotelId) {
        return new Builder()
                .name(name)
                .spaceSize(spaceSize)
                .bedType(bedType)
                .bedCount(bedCount)
                .bathInfo(bathInfo)
                .maxCapacity(maxCapacity)
                .hotelId(hotelId)
                .build();
    }

    //빌더 클래스
    public static class Builder {
        private String name;
        private int spaceSize;
        private String bedType;
        private int bedCount;
        private String bathInfo;
        private int maxCapacity;
        private long hotelId;

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder spaceSize(final int spaceSize) {
            this.spaceSize = spaceSize;
            return this;
        }

        public Builder bedType(final String bedType) {
            this.bedType = bedType;
            return this;
        }

        public Builder bedCount(final int bedCount) {
            this.bedCount = bedCount;
            return this;
        }

        public Builder bathInfo(final String bathInfo) {
            this.bathInfo = bathInfo;
            return this;
        }

        public Builder maxCapacity(final int maxCapacity) {
            this.maxCapacity = maxCapacity;
            return this;
        }

        public Builder hotelId(final long hotelId) {
            this.hotelId = hotelId;
            return this;
        }

        public Room build() {
            return new Room(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSpaceSize() {
        return spaceSize;
    }

    public String getBedType() {
        return bedType;
    }

    public int getBedCount() {
        return bedCount;
    }

    public String getBathInfo() {
        return bathInfo;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
