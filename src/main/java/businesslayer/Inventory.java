package businesslayer;

public class Inventory {

    private int id;
    private String name;
    private int length;
    private String unit;
    private String desc;
    private int status;
    private int price;

    /**
     * @param id
     * @param name
     * @param length
     * @param unit
     * @param desc
     * @param status
     * @param price
     */
    public Inventory(int id, String name, int length, String unit, String desc, int status, int price) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.unit = unit;
        this.desc = desc;
        this.status = status;
        this.price = price;
    }

    /**
     * @param id
     * @param name
     * @param length
     * @param desc
     */
    public Inventory(int id, String name, int length, String desc) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.desc = desc;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @return description
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
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
        if (length == 0) {
            return "<br><br>Id: " + id + "<br>Navn: " + name + "<br>Enhed: "
                    + unit + "<br>Beskrivelse: " + desc + "<br>Status: " + status + "<br>Price: " + price + "<br>";
        }

        return "<br><br>Id: " + id + "<br>Navn: " + name + "<br>Længde: " + length
                + "<br>Enhed: " + unit + "<br>Beskrivelse: " + desc + "<br>Status: " + status + "<br>Price: " + price + "<br>";
    }
}
