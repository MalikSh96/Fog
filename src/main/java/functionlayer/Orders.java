package functionlayer;

/**
 *
 * @author malik
 */
public class Orders 
{
    private int orderId; //id of order
    private int userId; //id of the user
    private int length; //length of the house
    private int width; //width of the house
    private int height; //height of the house
    private boolean orderConfirmed; //check if the order is confirmed and ready to delivery

    public Orders() {
    }

    public Orders(int orderId, int userId, int length, int width, int height) {
        this.orderId = orderId;
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Orders(int orderId, int userId, int length, int width, int height, boolean orderConfirmed) {
        this.orderId = orderId;
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.orderConfirmed = orderConfirmed;
    }
    
    public Orders(int userId, int length, int width, int height) {
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Orders(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isOrderConfirmed() {
        return orderConfirmed;
    }

    @Override
    public String toString() {
        return "<br>Order:<br>" + "<br>orderId: " + orderId + "<br>userId: " + userId + "<br>length: " + length 
                + "<br>width: " + width + "<br>height: " + height + "<br>orderConfirmed: " + orderConfirmed + "<br>";
    }
}
