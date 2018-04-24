package functionlayer;

/**
 *
 * @author malik
 */
public class Order 
{
    private int orderId; //id of order
    private int userId; //id of the user
    private int length; //length of the house
    private int width; //width of the house
    private int height; //height of the house
    private boolean orderConfirmed; //check if the order is confirmed and ready to delivery

    public Order(int userId, int length, int width, int height) {
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Order(int length, int width, int height) {
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
        return "Order:\n" + "orderId: " + orderId + "\nuserId: " + userId + "\nlength: " + length 
                + "\nwidth: " + width + "\nheight: " + height + "\norderConfirmed: " + orderConfirmed;
    }
}
