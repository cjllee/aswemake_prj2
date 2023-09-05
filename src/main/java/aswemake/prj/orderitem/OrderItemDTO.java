package aswemake.prj.orderitem;

import aswemake.prj.coupon.Coupon;
import aswemake.prj.item.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {
    private Long id;
    private Item item;
    private int orderPrice;
    private int count;
    private Coupon coupon;
    private Long itemId;
    private Long couponId;

    public OrderItemDTO(Long id, Item item, int orderPrice, int count, Coupon coupon, Long itemId, Long couponId) {
        this.id = id;
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
        this.coupon = coupon;
        this.itemId = itemId;
        this.couponId = couponId;
    }
}