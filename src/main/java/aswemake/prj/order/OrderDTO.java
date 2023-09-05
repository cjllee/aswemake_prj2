package aswemake.prj.order;

import aswemake.prj.orderitem.OrderItemDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private List<OrderItemDTO> orderItems;
    private double totalCost;

    public OrderDTO(Long id, List<OrderItemDTO> orderItems, double totalCost) {
        this.id = id;
        this.orderItems = orderItems;
        this.totalCost = totalCost;
    }
}
