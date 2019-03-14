package repository;

import models.ItemIt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItRepo extends JpaRepository <ItemIt,Long> {

    ItemIt findItemItById (Long id);


}
