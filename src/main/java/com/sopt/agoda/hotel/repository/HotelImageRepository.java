package com.sopt.agoda.hotel.repository;

import com.sopt.agoda.hotel.domain.HotelImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelImageRepository extends JpaRepository<HotelImage, Long> {
    @Query(value = """
        SELECT hi.hotelId, hi.imageUrl
        FROM HotelImage hi
        WHERE hi.hotelId IN :hotelIds
        AND hi.isThumbnail = TRUE
        """)
    List<Object[]> findFirstImagesForHotels(List<Long> hotelIds);
}
