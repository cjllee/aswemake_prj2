package aswemake.prj.delivery;

import jakarta.persistence.*;
import aswemake.prj.order.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    private int deliveryFee;

    @OneToOne(mappedBy = "delivery" , fetch = FetchType.LAZY)
    private Order order;


}