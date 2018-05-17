/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionlayer;

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
        postRow = (carportLength / 2); //divide by 2 because we want a post for every 2m
        
        if(carportWidth < 8) //max carport width is 8
        {
            postTotal = postRow * 2;
        } 
        else 
        {
            int numberOfRows = (carportWidth / 8);
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
        raftRow = (carportLength / 0.55); //0.55 is length of gap between the rafts
        
        int raftRowInt = raftRow.intValue();
        
        if(carportWidth < 8)
        {
            raftTotal = raftRowInt +2;
        }
        else
        {
            int numberOfRows = (carportWidth / 8);
            numberOfRows++;
            raftTotal = numberOfRows * raftRowInt;
        }
        
        raft.add(raftTotal);
        return raft;
    }
    
    public List<Integer> remAmount(int carportLength, int carportWidth)
    {
        int remTotal = 2; //Carport only have 2 sides, no middle posts
        rem.add(remTotal);
        return rem;
    }
    
    public List<Integer> roofAmount(int carportLength, int carportWidth)
    {
        int roofTotal = 0;
        Double roofPlate = 0.00;
        roofPlate = (carportLength / 1.1); //1.1 is width of roof plate
        
        int roofPlateInt = roofPlate.intValue();
        
        if(carportWidth > 6)
        {
            roofTotal = (roofPlateInt + 1) * 2; //
        } 
        else 
        {
            roofTotal += roofPlateInt + 1; //add +1 because working with int, results in one less because int cuts decimals
        }        
        
        roof.add(roofTotal);
        return roof;
    }
    
    //Work in progress
    public boolean buildShed(int carportWidth)
    {
        boolean shed = false;
        int shedWidth = 0;
        if(!shed && carportWidth == shedWidth)
        {
            int extraPost = 2;
            post.add(extraPost);           
        }
        if(!shed && carportWidth > shedWidth)
        {
            int extraPost = 3;
            post.add(extraPost);
        }
        
        return false;
    }
}
