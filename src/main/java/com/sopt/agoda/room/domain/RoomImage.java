package com.sopt.agoda.room.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "room_images")
public class RoomImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_image_id")
    private Long id;

    @Column(name = "room_image_url", nullable = false, length = 255)
    @NotBlank(message = "방 이미지 URL이 null이면 안됩니다.")
    private String imageUrl;

    @Column(name = "room_id", nullable = false)
    @NotNull(message = "방 ID가 null이면 안됩니다.")
    private Long roomId;

    protected RoomImage() {
    }

    private RoomImage(final Builder builder) {
        this.imageUrl = builder.roomImageUrl;
        this.roomId = builder.roomId;
    }

    public static RoomImage create(final String roomImageUrl, final Long roomId) {
        return new Builder()
                .roomImageUrl(roomImageUrl)
                .roomId(roomId)
                .build();
    }

    //빌더 클래스
    public static class Builder {
        private String roomImageUrl;
        private Long roomId;

        public Builder roomImageUrl(final String roomImageUrl) {
            this.roomImageUrl = roomImageUrl;
            return this;
        }

        public Builder roomId(final Long roomId) {
            this.roomId = roomId;
            return this;
        }

        public RoomImage build() {
            return new RoomImage(this);
        }
    }
}