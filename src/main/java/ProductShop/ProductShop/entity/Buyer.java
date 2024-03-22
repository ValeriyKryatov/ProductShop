package ProductShop.ProductShop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Создаем сущность "Покупатель", имеющую свойства:
 * 1) id - идентификационный номер покупателя,
 * 2) firstName - имя покупателя,
 * 3) lastName - фамилия покупателя
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "buyer")
    @JsonIgnore
    private Set<Purchase> purchases = new HashSet<>();
}
