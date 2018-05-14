package functionlayer;

public class Inventory 
{    
    private int id;
    private String name;
    private int length;
    private String unit;
    private String desc;
    private int status;

    public Inventory(int id, String name, int length, String unit, String desc, int status) {
        
    }

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
        this.status = status;
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
        if(length == 0) { return "<br><br>Id: " + id + "<br>Navn: " + name + "<br>Enhed: "+ unit + "<br>Beskrivelse: " + desc + "<br>Status: " + status + "<br>";}
        return "<br><br>Id: " + id + "<br>Navn: " + name + "<br>Længde: " + length + "<br>Enhed: "+ unit + "<br>Beskrivelse: " + desc + "<br>Status: " + status + "<br>";

    }
}
