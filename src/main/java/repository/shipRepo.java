package repository;

import models.Ship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface shipRepo extends JpaRepository<Ship,Long> {

    Ship findByShipname(String shipname );
    Ship findShipsById (Long id);
    Page<Ship> findByShipnameOrDescription(String filter, String desc, Pageable pageable);

    List<Ship> findByShipnameOrDescription(String filter, String desc);

    List<Ship> findAllByOrderByTimeStamp ();

    List<Ship> findAllByOrderByIdDesc();

}
