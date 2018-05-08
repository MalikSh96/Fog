package functionlayer;


public class Inventory {
    
    int id = 0;
    String name;
    int length;
    String desc;

    public Inventory(int id, String name, int length, String desc) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Inventory{" + "id=" + id + ", name=" + name + ", length=" + length + ", desc=" + desc + '}' +"\n";
    }
    
    
    
    
    
    
    
}
