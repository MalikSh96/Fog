package functionlayer;

public class Inventory 
{    
    private int id;
    private String name;
    private int length;
    private String unit;
    private String desc;

    public Inventory(int id, String name, int length, String desc) 
    {
        this.id = id;
        this.name = name;
        this.length = length;
        this.desc = desc;
    }

    public Inventory(int id, String name, int length, String unit, String desc) 
    {
        this.id = id;
        this.name = name;
        this.length = length;
        this.unit = unit;
        this.desc = desc;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public String getUnit() {
        return unit;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Inventory{" + "id=" + id + ", name=" + name + ", length=" + length + ", unit=" + unit + ", desc=" + desc + '}';
    }
}
