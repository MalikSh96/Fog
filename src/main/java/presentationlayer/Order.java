package presentationlayer;

import businesslayer.Constants;
import businesslayer.UniversalExceptions;
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
    boolean toolshed_checkbox;
    int heightline = 0;

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions, ClassNotFoundException {

        HttpSession session = request.getSession();

        //find user
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.setAttribute("from", "customorder");
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
        widthSVG = width + 60;
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
        toolshed_checkbox = request.getParameter("toolshed_checkbox") != null;

        if (toolshed_checkbox == true) {
            toolshedlength = Integer.parseInt(request.getParameter("toolshedlength"));
            toolshedwidth = Integer.parseInt(request.getParameter("toolshedwidth"));
        } else {
            toolshedlength = 0;
            toolshedwidth = 0;

        }
        if(request.getParameter("toolshedlength").length() > 0) { toolshedlength = Integer.parseInt(request.getParameter("toolshedlength"));}
        if(request.getParameter("toolshedwidth").length() > 0) { toolshedwidth = Integer.parseInt(request.getParameter("toolshedwidth"));}

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

        con.getBf().createOrder(userID, length, width, height);

        con.getBf().addToItemList(con.getBf().getItemName(8), con.getBf().getItemDescription(8), con.getBf().getItemLength(8), remAmount, con.getBf().getOrderId(), 8);
        con.getBf().addToItemList(con.getBf().getItemName(10), con.getBf().getItemDescription(10), con.getBf().getItemLength(10), raftAmount, con.getBf().getOrderId(), 10);
        con.getBf().addToItemList(con.getBf().getItemName(11), con.getBf().getItemDescription(11), con.getBf().getItemLength(11), postAmount, con.getBf().getOrderId(), 11);
        con.getBf().addToItemList(con.getBf().getItemName(15), con.getBf().getItemDescription(15), con.getBf().getItemLength(15), roofAmount, con.getBf().getOrderId(), 15);
        con.getBf().addToItemList(con.getBf().getItemName(17), con.getBf().getItemDescription(17), con.getBf().getItemLength(17), con.getROOFSCREWAMOUNT(), con.getBf().getOrderId(), 17);
        con.getBf().addToItemList(con.getBf().getItemName(19), con.getBf().getItemDescription(19), con.getBf().getItemLength(19), con.getUNIVERSALRIGHTAMOUNT(), con.getBf().getOrderId(), 19);
        con.getBf().addToItemList(con.getBf().getItemName(20), con.getBf().getItemDescription(20), con.getBf().getItemLength(20), con.getUNIVERSALLEFTAMOUNT(), con.getBf().getOrderId(), 20);
        con.getBf().addToItemList(con.getBf().getItemName(22), con.getBf().getItemDescription(22), con.getBf().getItemLength(22), con.getBRACKETSCREWAMOUNT(), con.getBf().getOrderId(), 22);
        con.getBf().addToItemList(con.getBf().getItemName(23), con.getBf().getItemDescription(23), con.getBf().getItemLength(23), con.getCARRIAGEBOLTAMOUNT(), con.getBf().getOrderId(), 23);
        con.getBf().addToItemList(con.getBf().getItemName(24), con.getBf().getItemDescription(24), con.getBf().getItemLength(24), con.getSQUARESLICESAMOUNT(), con.getBf().getOrderId(), 24);
        
        totalPrice += con.getBf().getItemPrice(8) * remAmount;
        totalPrice += con.getBf().getItemPrice(10) * raftAmount;
        totalPrice += con.getBf().getItemPrice(11) * postAmount;
        totalPrice += con.getBf().getItemPrice(15) * roofAmount;
        totalPrice += con.getBf().getItemPrice(17) * con.getROOFSCREWAMOUNT();
        totalPrice += con.getBf().getItemPrice(19) * con.getUNIVERSALRIGHTAMOUNT();
        totalPrice += con.getBf().getItemPrice(20) * con.getUNIVERSALLEFTAMOUNT();
        totalPrice += con.getBf().getItemPrice(22) * con.getBRACKETSCREWAMOUNT();
        totalPrice += con.getBf().getItemPrice(23) * con.getCARRIAGEBOLTAMOUNT();
        totalPrice += con.getBf().getItemPrice(24) * con.getSQUARESLICESAMOUNT();        
        
        con.getBf().updateTotalPrice(totalPrice, con.getBf().getOrderId());
        
        return "order";
    }
}
