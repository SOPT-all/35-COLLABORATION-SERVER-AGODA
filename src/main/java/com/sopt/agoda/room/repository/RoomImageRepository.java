package com.sopt.agoda.room.repository;

import com.sopt.agoda.room.domain.RoomImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomImageRepository extends JpaRepository<RoomImage, Long> {
    List<RoomImage> findByRoomIdInOrderById(List<Long> roomIds);
}