/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslayer;

import datalayer.InventoryMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author malik
 */
public class ItemList 
{
    
    private List<Integer> post = new ArrayList<>();
    private List<Integer> raft = new ArrayList<>();
    private List<Integer> rem = new ArrayList<>();
    private List<Integer> roof = new ArrayList<>();
    private int postTotal = 0;
    private int raftTotal = 0;
    private int remTotal = 0;
    private int roofTotal = 0;
    
    //Obs, calculations is based of the biggest items of each category
    
    public static List<Integer> postAmount(int carportLength, int carportWidth)
    {
        int postRow = 0;
        postRow = (carportLength / 200); //divide by 2 because we want a post for every 2m/200cm

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
    
    public static List<Integer> raftAmount(int carportLength, int carportWidth)
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
    
    public static List<Integer> remAmount(int carportLength) 
    {
        //Carport only have 2 sides, no middle posts
        if(carportLength <= 6) { remTotal = 2;}
        else { remTotal = 4;}
        rem.add(remTotal);
        return rem;
    }
    
    public static List<Integer> roofAmount(int carportLength, int carportWidth)
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
    public static void Shed(int carportWidth, int shedWidth)
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

    public static List<Integer> getPost() {
        return post;
    }

    public static List<Integer> getRaft() {
        return raft;
    }

    public static List<Integer> getRem() {
        return rem;
    }

    public static List<Integer> getRoof() {
        return roof;
    }

    //Getters for the purpose of j-unit testing
    public static int getPostTotal() {
        return postTotal;
    }

    public static int getRaftTotal() {
        return raftTotal;
    }

    public static int getRemTotal() {
        return remTotal;
    }

    public static int getRoofTotal() {
        return roofTotal;
    }
}
