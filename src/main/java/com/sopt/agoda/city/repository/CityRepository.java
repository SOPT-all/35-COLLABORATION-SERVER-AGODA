package com.sopt.agoda.city.repository;

import com.sopt.agoda.city.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
