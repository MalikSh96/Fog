/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import dbaccess.InventoryMapper;
import dbaccess.OrderMapper;
import functionlayer.ItemList;
import functionlayer.LoginSampleException;
import functionlayer.Orders;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import functionlayer.User;
/**
 *
 * @author Joklin
 */
public class Order extends Command {

    OrderMapper om = new OrderMapper();
        ItemList itemList = new ItemList();
        InventoryMapper im = new InventoryMapper();
        
    int userID = 0;
    int length = 0;
    int width = 0;
    int height = 0;
    int lengthrafter = 0;
    int heightrafter = 0;
    int widthrafter = 0;
    int widthSVG = 0;
    int lengthSVG = 0;
    int widthline = 0;
    
    int lengthline = 0;
    int lengthtextmiddle = 0;
    int widthtextmiddle = 0;
    int roof_tiles = 0;
    int heightSVG = 0;
    int heightground = 0;
    int heightpost = 0;
    int toolshedlength = 0;
    int toolshedwidth = 0;
    int heightline = 0;
    
    //hardcoding of misc carport stuff
    String roofScrewName = im.getName(17);
    String roofScrewDesc = im.getDescription(17);
    int roofScrewAmount = 2;
    
    String universalRightName = im.getName(19);
    String universalRightDesc = im.getDescription(19);
    int universalRightAmount = 20;
    
    String universalLeftName = im.getName(20);
    String universalLeftDesc = im.getDescription(20);
    int universalLeftAmount = 20;
    
    
    String bracketScrewName = im.getName(22);
    String bracketScrewDesc = im.getDescription(22);
    int bracketScrewAmount = 2;
            
            
    String carriageBoltName = im.getName(23);
    String carriageBoltDesc = im.getDescription(23);
    int carriageBoltAmount = 14;
            
            
    String squareSlicesName = im.getName(24);
    String squareSlicesDesc = im.getDescription(24);
    int squareSlicesAmount = 14;
            
            
   
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){ 
        return "loginpage";
        }
        userID = (int) session.getAttribute("id");
        length = Integer.parseInt(request.getParameter("length"));
        width = Integer.parseInt(request.getParameter("width"));
        height = Integer.parseInt(request.getParameter("height"));
        lengthrafter = Integer.parseInt(request.getParameter("length")) - 6;
        widthrafter = Integer.parseInt(request.getParameter("width")) - 23 + 30;
        heightrafter = Integer.parseInt(request.getParameter("height")) - 5;
        widthSVG = Integer.parseInt(request.getParameter("width")) + 60;
        lengthSVG = Integer.parseInt(request.getParameter("length")) + 65;
        heightSVG = Integer.parseInt(request.getParameter("height")) + 65;
        widthline = Integer.parseInt(request.getParameter("width")) + 15 + 30;
        lengthline = Integer.parseInt(request.getParameter("length")) + 15 ;
        lengthtextmiddle = Integer.parseInt(request.getParameter("length")) / 2;
        widthtextmiddle = Integer.parseInt(request.getParameter("width")) / 2 + 30;
        roof_tiles = 110;
        heightpost = Integer.parseInt(request.getParameter("height")) - 50;
        heightground = Integer.parseInt(request.getParameter("height"));
        heightline = Integer.parseInt(request.getParameter("height"));
        toolshedlength = Integer.parseInt(request.getParameter("toolshedlength"));
        toolshedwidth = Integer.parseInt(request.getParameter("toolshedwidth"));        
     //   PreOrder pre = new PreOrder(userID, length, width, height); 

        session.setAttribute("længde", length);
        session.setAttribute("bredde", width);
        session.setAttribute("redskabsrumlængde", toolshedlength);
        session.setAttribute("redskabsrumbredde", toolshedwidth);
        session.setAttribute("højde", height);
        
        session.setAttribute("længdespær", lengthrafter);
        session.setAttribute("højdespær", heightrafter);
        session.setAttribute("breddespær", widthrafter);
        
        session.setAttribute("breddeSVG", widthSVG);
        session.setAttribute("længdeSVG", lengthSVG);
        session.setAttribute("højdeSVG", heightSVG);
        session.setAttribute("højdelinje", heightline);
        session.setAttribute("breddelinje", widthline);
        session.setAttribute("længdelinje", lengthline);
        session.setAttribute("højdestolpe", heightpost);
        session.setAttribute("længdemidtentekst", lengthtextmiddle);
        session.setAttribute("breddemidtentekst", widthtextmiddle);
        session.setAttribute("tagsten", roof_tiles);
        session.setAttribute("højdejord", heightground);
        Orders ord = new Orders(userID, length, width, height);
        om.createPreOrder(ord);  
                
     
        session.setAttribute("postName", im.getName(11));
        session.setAttribute("postDesc", im.getDescription(11));
        session.setAttribute("postLength", im.getLength(11));
        session.setAttribute("postAmount" , itemList.postAmount(length, width).get(0));
     
        session.setAttribute("raftName", im.getName(10));
        session.setAttribute("raftDesc", im.getDescription(10));
        session.setAttribute("raftLength", im.getLength(10));
        session.setAttribute("raftAmount" , itemList.raftAmount(length, width).get(0));
     
        session.setAttribute("remName", im.getName(8));
        session.setAttribute("remDesc", im.getDescription(8));
        session.setAttribute("remLength", im.getLength(8));
        session.setAttribute("remAmount" , itemList.remAmount(length).get(0));
      //  session.setAttribute("remAmount" , itemList.remAmount(length, width).get(0));
     
        session.setAttribute("roofName", im.getName(15));
        session.setAttribute("roofDesc", im.getDescription(15));
        session.setAttribute("roofLength", im.getLength(15));
        session.setAttribute( "roofAmount" , itemList.roofAmount(length, width).get(0));
        
        session.setAttribute("roofScrewName", im.getName(17));
        session.setAttribute("roofScrewDesc", im.getDescription(17));
        session.setAttribute("roofScrewAmount", roofScrewAmount);
        
        session.setAttribute("universalRightName", im.getName(19));
        session.setAttribute("universalRightDesc", im.getDescription(19));
        session.setAttribute("universalRightAmount", universalRightAmount);
        
        session.setAttribute("universalLeftName", im.getName(20));
        session.setAttribute("universalLeftDesc", im.getDescription(20));
        session.setAttribute("universalLeftAmount", universalLeftAmount);
        
        session.setAttribute("bracketScrewName", im.getName(22));
        session.setAttribute("bracketScrewDesc", im.getDescription(22));
        session.setAttribute("bracketScrewAmount", bracketScrewAmount);
        
        session.setAttribute("carriageBoltName", im.getName(23));
        session.setAttribute("carriageBoltDesc", im.getDescription(23));
        session.setAttribute("carriageBoltAmount", carriageBoltAmount);
        
        session.setAttribute("squareSlicesName", im.getName(24));
        session.setAttribute("squareSlicesDesc", im.getDescription(24));
        session.setAttribute("squareSlicesAmount", squareSlicesAmount);
        
        
        
              return "order";
    }

}




