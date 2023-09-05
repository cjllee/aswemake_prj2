package aswemake.prj.coupon;

import aswemake.prj.item.Item;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

    @Id
    @GeneratedValue
    private Long id;

    // 쿠폰 할인율 또는 할인액 (e.g., if fixedAmount is null, use discountRate.)
    private Double discountRate;
    private Integer fixedAmount;

    // Coupon can be applied to a specific item or an entire order.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

}