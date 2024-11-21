package com.sopt.agoda.hotel.repository;

import com.sopt.agoda.hotel.domain.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelImageRepository extends JpaRepository<HotelImage, Long> {
    @Query(value = """
        SELECT hi.hotel_id, hi.hotel_image_url
        FROM hotel_images hi
        WHERE hi.hotel_id IN :hotelIds
        AND hi.hotel_image_id IN (
            SELECT MIN(hi2.hotel_image_id)
            FROM hotel_images hi2
            WHERE hi2.hotel_id IN :hotelIds
            GROUP BY hi2.hotel_id
        )
        """, nativeQuery = true)
    List<Object[]> findFirstImagesForHotels(List<Long> hotelIds);
}
