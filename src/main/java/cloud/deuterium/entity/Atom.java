package cloud.deuterium.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Milan Stojkovic 25-Dec-2021
 */

@ToString
@Entity
public class Atom extends PanacheEntityBase {
    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String symbol;
    public double mass;
    public int orderNumber;
}
