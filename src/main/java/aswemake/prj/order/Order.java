package aswemake.prj.order;

import aswemake.prj.coupon.Coupon;
import aswemake.prj.coupon.CouponScope;
import aswemake.prj.delivery.Delivery;
import aswemake.prj.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import aswemake.prj.orderitem.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    List<Coupon> coupons = new ArrayList<>();

    private double totalCost;

    public double getTotalCost() {
        double cost = orderItems.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        cost += delivery.getDeliveryFee();

        for (Coupon coupon : coupons) {
            if (coupon.getCouponScope().equals(CouponScope.ORDER)) {
                switch(coupon.getDiscountType()) {
                    case PERCENT:
                        cost -= cost * coupon.getDiscountRate() / 100;
                        break;
                    case AMOUNT:
                        cost -= coupon.getFixedDiscountAmount().doubleValue(); // Integer to Double conversion
                        break;
                }
            }
        }

        return cost;
    }
}