package com.sopt.agoda.hotel.repository;

import com.sopt.agoda.hotel.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCityId(Long cityId);
    List<Hotel> findByCityIdAndIsTimeSaleFalse(Long cityId);
}
