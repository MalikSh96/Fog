package businesslayer;

public class Orders {

    private int orderId;
    private int userId;
    private int length;
    private int width;
    private int height;
    private int price;
    private boolean orderConfirmed;

    public Orders() {
    }

    /**
     * @param orderId
     * @param userId
     * @param length
     * @param width
     * @param height
     */
    public Orders(int orderId, int userId, int length, int width, int height) {
        this.orderId = orderId;
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * @param userId
     * @param length
     * @param width
     * @param height
     * @param price
     * @param priceIncluded
     * @param ex
     */
    public Orders(int userId, int length, int width, int height, int price, boolean priceIncluded, String ex) {
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.price = price;
    }

    /**
     * @param userId
     * @param length
     * @param width
     * @param height
     * @param orderConfirmed
     */
    public Orders(int userId, int length, int width, int height, boolean orderConfirmed) {
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.orderConfirmed = orderConfirmed;
    }

    /**
     * @param orderId
     * @param userId
     * @param length
     * @param width
     * @param height
     * @param orderConfirmed
     */
    public Orders(int orderId, int userId, int length, int width, int height, boolean orderConfirmed) {
        this.orderId = orderId;
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.orderConfirmed = orderConfirmed;
    }

    /**
     * @param userId
     * @param length
     * @param width
     * @param height
     */
    public Orders(int userId, int length, int width, int height) {
        this.userId = userId;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * @param length
     * @param width
     * @param height
     */
    public Orders(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * @return orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return boolean
     */
    public boolean isOrderConfirmed() {
        return orderConfirmed;
    }

    /**
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        if (orderConfirmed) {
            return "<br>Ordre Id: " + orderId + "<br><br>Bruger id: "
                    + userId + "<br>Længde: " + length + "<br>Bredde: " + width
                    + "<br>Højde: " + height + "<br>Status: sendt<br>";
        }

        return "<br>Ordre: Id: " + orderId + "<br><br>Bruger id: " + userId
                + "<br>Længde: " + length + "<br>Bredde: " + width + "<br>Højde: "
                + height + "<br>Status: ikke sendt<br>";
    }
}
