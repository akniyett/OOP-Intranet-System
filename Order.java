package finalProject;


import java.time.LocalDateTime;


public class Order implements Serializable {
   
    private LocalDateTime date = LocalDateTime.now();
    private OrderType orderType;
    private OrderStatus status;

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public Order(OrderType orderType) {
		this.orderType = orderType;
		this.status = OrderStatus.NOTPROCESSED;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [date=" + date + ", type=" + orderType + ",  status=" + status + "]";
	}
}

