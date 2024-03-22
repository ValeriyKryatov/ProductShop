package ProductShop.ProductShop.repository;

import ProductShop.ProductShop.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Создаем интерфейс-репозиторий для определения поиска по необходимым параметрам:
 * 1) findByLastNameContainsIgnoreCase() - поиск покупателя по фамилии,
 */
@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    List<Buyer> findByLastNameContainsIgnoreCase(String lastName);

    @Query("select b from Buyer b " +
            "inner join b.purchases pu " +
            "where pu.product.name=:productName" +
            "group by b " +
            "having count(b) >=:minPurchase"
    )
    List<Buyer> findBuyerByProduct(@Param("productName") String productName,
                                   @Param("minPurchase") Long minPurchase);
}