package businesslayer;

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
    private int price; //height of the house

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
    public Orders(int userId, int length, int width, int height, int price, boolean priceIncluded, String ex) {
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.price = price;
    }

    public Orders(int userId, int length, int width, int height, boolean orderConfirmed) {
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.orderConfirmed = orderConfirmed;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        if(orderConfirmed) return "<br>Id: " + orderId + "<br><br>Bruger id: " + userId + "<br>Længde: " + length + "<br>Bredde: " + width + "<br>Højde: " + height + "<br>Status: sendt<br>";
        return "<br>Id: " + orderId + "<br><br>Bruger id: " + userId + "<br>Længde: " + length + "<br>Bredde: " + width + "<br>Højde: " + height + "<br>Status: ikke sendt<br>";
    }
}
