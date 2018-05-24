package presentationlayer;

import businesslayer.Constants;
import businesslayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import businesslayer.User;
import java.util.ArrayList;
import java.util.List;

public class Order extends Command {    
    
    Constants con = new Constants();
   
    int totalPrice = 0;
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

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        
        //find user
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.getParameter("needuser");
            return "loginpage";
        }

        //assign user and get all input        
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
        lengthline = Integer.parseInt(request.getParameter("length")) + 15;
        lengthtextmiddle = Integer.parseInt(request.getParameter("length")) / 2;
        widthtextmiddle = Integer.parseInt(request.getParameter("width")) / 2 + 30;
        roof_tiles = 110;
        heightpost = Integer.parseInt(request.getParameter("height")) - 50;
        heightground = Integer.parseInt(request.getParameter("height"));
        heightline = Integer.parseInt(request.getParameter("height"));
        toolshedlength = Integer.parseInt(request.getParameter("toolshedlength"));
        toolshedwidth = Integer.parseInt(request.getParameter("toolshedwidth"));

        //put all input into attributes
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
   
        //make the itemlist        
        int remAmount = con.getBf().calculateRemAmount(length);
        int raftAmount = con.getBf().calculateRaftAmount(length, width);
        int postAmount = con.getBf().calculatePostAmount(length, width);
        int roofAmount = con.getBf().calculateRoofAmount(length, width);
       
        con.getBf().createItemList(con.getBf().getItemName(8), con.getBf().getItemDescription(8), con.getBf().getItemLength(8), remAmount, con.getBf().getOrderId(), userID);
        con.getBf().createItemList(con.getBf().getItemName(10), con.getBf().getItemDescription(10), con.getBf().getItemLength(8), raftAmount, con.getBf().getOrderId(), userID);
        con.getBf().createItemList(con.getBf().getItemName(11), con.getBf().getItemDescription(11), con.getBf().getItemLength(8), postAmount, con.getBf().getOrderId(), userID);
        con.getBf().createItemList(con.getBf().getItemName(15), con.getBf().getItemDescription(15), con.getBf().getItemLength(8), roofAmount, con.getBf().getOrderId(), userID);
        con.getBf().createItemList(con.getBf().getItemName(17), con.getBf().getItemDescription(17), con.getBf().getItemLength(8), con.getBf().calculateRemAmount(length), con.getBf().getOrderId(), userID);
        con.getBf().createItemList(con.getBf().getItemName(19), con.getBf().getItemDescription(19), con.getBf().getItemLength(8), con.getBf().calculateRemAmount(length), con.getBf().getOrderId(), userID);
        con.getBf().createItemList(con.getBf().getItemName(20), con.getBf().getItemDescription(20), con.getBf().getItemLength(8), con.getBf().calculateRemAmount(length), con.getBf().getOrderId(), userID);
        con.getBf().createItemList(con.getBf().getItemName(22), con.getBf().getItemDescription(22), con.getBf().getItemLength(8), con.getBf().calculateRemAmount(length), con.getBf().getOrderId(), userID);
        con.getBf().createItemList(con.getBf().getItemName(23), con.getBf().getItemDescription(23), con.getBf().getItemLength(8), con.getBf().calculateRemAmount(length), con.getBf().getOrderId(), userID);
        con.getBf().createItemList(con.getBf().getItemName(24), con.getBf().getItemDescription(24), con.getBf().getItemLength(8), con.getBf().calculateRemAmount(length), con.getBf().getOrderId(), userID);       

        List<String> list = con.getBf().getFullItemlist(con.getBf().getOrderId());
        List<Integer> amountList = new ArrayList<>();
        
        if(list.size() == amountList.size()) {
        for (int i = 0; i < list.size(); i++) {
            totalPrice += con.getBf().calculateTotalPrice(con.getBf().getItemPrice(i), amountList.get(i));
        }        
        }
        
        if(totalPrice != 0) {
        con.getBf().createOrder(userID, length, width, height, totalPrice, true, "priced");        

        con.getBf().addToItemlist(con.getBf().getItemName(8), con.getBf().getItemDescription(8), con.getBf().getItemLength(8), remAmount, con.getBf().getOrderId(), con.getBf().getItemId(con.getBf().getItemName(8)));
        con.getBf().addToItemlist(con.getBf().getItemName(10), con.getBf().getItemDescription(10), con.getBf().getItemLength(10), raftAmount, con.getBf().getOrderId(), con.getBf().getItemId(con.getBf().getItemName(10)));
        con.getBf().addToItemlist(con.getBf().getItemName(11), con.getBf().getItemDescription(11), con.getBf().getItemLength(11), postAmount, con.getBf().getOrderId(), con.getBf().getItemId(con.getBf().getItemName(11)));
        con.getBf().addToItemlist(con.getBf().getItemName(15), con.getBf().getItemDescription(15), con.getBf().getItemLength(15), roofAmount, con.getBf().getOrderId(), con.getBf().getItemId(con.getBf().getItemName(15)));
        con.getBf().addToItemlist(con.getBf().getItemName(17), con.getBf().getItemDescription(17), 0, con.getROOFSCREWAMOUNT(), con.getBf().getOrderId(), con.getBf().getItemId(con.getBf().getItemName(17)));
        con.getBf().addToItemlist(con.getBf().getItemName(19), con.getBf().getItemDescription(19), 0, con.getUNIVERSALRIGHTAMOUNT(), con.getBf().getOrderId(), con.getBf().getItemId(con.getBf().getItemName(19)));
        con.getBf().addToItemlist(con.getBf().getItemName(20), con.getBf().getItemDescription(20), 0, con.getUNIVERSALLEFTAMOUNT(), con.getBf().getOrderId(), con.getBf().getItemId(con.getBf().getItemName(20)));
        con.getBf().addToItemlist(con.getBf().getItemName(22), con.getBf().getItemDescription(22), 0, con.getBRACKETSCREWAMOUNT(), con.getBf().getOrderId(), con.getBf().getItemId(con.getBf().getItemName(22)));
        con.getBf().addToItemlist(con.getBf().getItemName(23), con.getBf().getItemDescription(23), 0, con.getCARRIAGEBOLTAMOUNT(), con.getBf().getOrderId(), con.getBf().getItemId(con.getBf().getItemName(23)));
        con.getBf().addToItemlist(con.getBf().getItemName(24), con.getBf().getItemDescription(24), 0, con.getSQUARESLICESAMOUNT(), con.getBf().getOrderId(), con.getBf().getItemId(con.getBf().getItemName(24)));
        
        totalPrice = 0;
        }
        
        return "order";
    }
}
