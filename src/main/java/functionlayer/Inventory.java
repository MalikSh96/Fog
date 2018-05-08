package functionlayer;


public class Inventory {
    
    int id = 0;
    String name;
    int length;
    String unit;
    String desc;

    public Inventory(int id, String name, int length, String unit, String desc) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.unit = unit;
        this.desc = desc;
    }

    @Override
    public String toString() {
        if(length == 0) {    return "<br><br>Id: " + id + "<br>Navn: " + name + "<br>Enhed: "+ unit + "<br>Beskrivelse: " + desc +"<br>";}
        return "<br><br>Id: " + id + "<br>Navn: " + name + "<br>Længde: " + length + "<br>Enhed: "+ unit + "<br>Beskrivelse: " + desc +"<br>";
    }
    
    
    
    
    
    
    
}
