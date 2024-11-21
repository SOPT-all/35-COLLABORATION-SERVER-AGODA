package com.sopt.agoda.hotel.repository;

import com.sopt.agoda.hotel.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCityId(Long cityId);
    List<Hotel> findByCityIdAndIsTimeSaleFalse(Long cityId);
}
