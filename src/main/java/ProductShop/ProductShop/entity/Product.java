package ProductShop.ProductShop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Создаем сущность "Товар", имеющую свойства:
 * 1) id - идентификационный номер товара,
 * 2) name - наименование товара,
 * 3) cost - расходы на товар
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Long cost;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<Purchase> purchases = new HashSet<>();
}