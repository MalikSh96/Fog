/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionlayer;

import com.oracle.jrockit.jfr.DataType;
import dbaccess.InventoryMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author malik
 */
public class ItemList 
{
    private InventoryMapper im = new InventoryMapper();
    
    private List<Integer> post = new ArrayList<>();
    private List<Integer> raft = new ArrayList<>();
    private List<Integer> rem = new ArrayList<>();
    private List<Integer> roof = new ArrayList<>();
        
    public List<Integer> postAmount(int carportLength, int carportWidth)
    {
        int postTotal = 0;
        int postRow = 0;
        postRow = (carportLength / 2);
        
        if(carportWidth < 6)
        {
            postTotal = postRow * 2;
        } 
        else 
        {
            int numberOfRows = (carportWidth/6);
            numberOfRows++;
            postTotal =  numberOfRows * postRow;
        }
        
        post.add(postTotal);
        return post;
    }
    
    public List<Integer> raftAmount(int carportLength, int carportWidth)
    {
        int raftTotal = 0;
        Double raftRow = 0.00;
        raftRow = (carportLength / 0.55);
        
        int raftRowInt = raftRow.intValue();
        
        if(carportWidth < 6)
        {
            raftTotal = raftRowInt +2;
        }
        else
        {
            int numberOfRows = (carportWidth/6);
            numberOfRows++;
            raftTotal = numberOfRows * raftRowInt;
        }
        
        raft.add(raftTotal);
        return raft;
    }
    
    public List<Integer> remAmount(int carportLength, int carportWidth)
    {
        int remTotal = 0;
        rem.add(remTotal);
        return rem;
    }
    
    public List<Integer> roofAmount(int carportLength, int carportWidth)
    {
        int roofTotal = 0;
        roof.add(roofTotal);
        return roof;
    }
}
