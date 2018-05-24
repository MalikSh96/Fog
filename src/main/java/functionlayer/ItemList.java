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
    private int postTotal = 0;
    private int raftTotal = 0;
    private int remTotal = 0;
    private int roofTotal = 0;
    
    //Obs, calculations is based of the biggest items of each category
    
    public List<Integer> postAmount(int carportLength, int carportWidth)
    {
        int postRow = 0;
        postRow = ((carportLength -40) / 200); //divide by 2 because we want a post for every 2m/200cm, -40 to support the extra hangout

        if(carportWidth < 800) //max carport width is 8m or 800cm
        {
            postTotal = (postRow * 2) + 2;
        } 
        else 
        {
            int numberOfRows = (carportWidth / 800); 
            numberOfRows += 2; //adds 2, because once the width is over 8, middle posts is needed
            postTotal =  numberOfRows * postRow;
        }        
        post.add(postTotal);
        return post;
    }
    
    public List<Integer> raftAmount(int carportLength, int carportWidth)
    {
        Double raftRow = 0.00;
        raftRow = (carportLength / 55.00); //0.55 is length of gap between the rafts
        
        int raftRowInt = raftRow.intValue();
        
        if(carportWidth < 800)
        {
            raftTotal = raftRowInt +2;
        }
        else
        {
            int numberOfRows = (carportWidth / 800);
            numberOfRows++;
            raftTotal = numberOfRows * raftRowInt;
        }
        
        raft.add(raftTotal);
        return raft;
    }
    
    public List<Integer> remAmount(int carportLength) 
    {
        //Carport only have 2 sides, no middle posts
        if(carportLength <= 6) { remTotal = 2;}
        else { remTotal = 4;}
        rem.add(remTotal);
        return rem;
    }
    
    public List<Integer> roofAmount(int carportLength, int carportWidth)
    {
        Double roofPlate = 0.00;
        roofPlate = (carportLength / 110.00); //1.1 is width of roof plate
        
        int roofPlateInt = roofPlate.intValue();
        
        if(carportWidth > 600)
        {
            roofTotal = (roofPlateInt + 1) * 2; 
        } 
        else 
        {
            roofTotal += roofPlateInt + 1; //add +1 because working with int, results in one less because int cuts decimals
            
        }        
        
        roof.add(roofTotal);
        return roof;
    }
    
    //Work in progress
    public void Shed(int carportWidth, int shedWidth)
    {
        if(carportWidth == shedWidth)
        {
            int extraPost = 2;
            post.add(extraPost);  
        }
        if(carportWidth > shedWidth)
        {
            int extraPost = 3;
            post.add(extraPost);
        }
    }

    public List<Integer> getPost() {
        return post;
    }

    public List<Integer> getRaft() {
        return raft;
    }

    public List<Integer> getRem() {
        return rem;
    }

    public List<Integer> getRoof() {
        return roof;
    }

    //Getters for the purpose of j-unit testing
    public int getPostTotal() {
        return postTotal;
    }

    public int getRaftTotal() {
        return raftTotal;
    }

    public int getRemTotal() {
        return remTotal;
    }

    public int getRoofTotal() {
        return roofTotal;
    }
}
