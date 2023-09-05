package aswemake.prj.orderitem;

import aswemake.prj.coupon.Coupon;
import aswemake.prj.item.Item;
import jakarta.persistence.*;
import aswemake.prj.order.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class OrderItem {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; // 주문 가격을 위한 필드 추가
    private int count; // 주문 수량을 위한 필드 추가

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="coupon_id")
    private Coupon coupon;


    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        return orderItem;
    }

    public int getTotalPrice(){
        return getOrderPrice() * getCount(); // 총 가격 계산 메소드
    }

}