package presentationlayer;

import dbaccess.InventoryMapper;
import dbaccess.ItemlistMapper;
import dbaccess.OrderMapper;
import functionlayer.ItemList;
import functionlayer.UniversalExceptions;
import functionlayer.Orders;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import functionlayer.User;

public class Order extends Command {

    OrderMapper om = new OrderMapper();
    ItemList itemList = new ItemList();
    InventoryMapper im = new InventoryMapper();
    ItemlistMapper ilm = new ItemlistMapper();
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
    String[] toolshed_checkbox;
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
    String execute(HttpServletRequest request, HttpServletResponse response) throws UniversalExceptions, ClassNotFoundException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            request.setAttribute("from", "customorder");
            return "loginpage";
        }

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
//        toolshed_checkbox = request.getParameterValues("toolshed_checkbox");
//        boolean checked = true;
//        if(toolshed_checkbox[0].equals(checked)){
            toolshedlength = Integer.parseInt(request.getParameter("toolshedlength"));
            toolshedwidth = Integer.parseInt(request.getParameter("toolshedwidth"));
//        }
//        else {
//        toolshedlength = 0;
//        toolshedwidth = 0;       
     
//        }
//            
     
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

        totalPrice += im.getPrice(8) * itemList.remAmount(length).get(0);
        totalPrice += im.getPrice(10) * itemList.raftAmount(length, width).get(0);
        totalPrice += im.getPrice(11) * itemList.postAmount(length, width).get(0);
        totalPrice += im.getPrice(15) * itemList.roofAmount(length, width).get(0);
        totalPrice += im.getPrice(17) * roofScrewAmount;
        totalPrice += im.getPrice(19) * universalRightAmount;
        totalPrice += im.getPrice(20) * universalLeftAmount;
        totalPrice += im.getPrice(22) * bracketScrewAmount;
        totalPrice += im.getPrice(23) * carriageBoltAmount;
        totalPrice += im.getPrice(24) * squareSlicesAmount;

        Orders ord = new Orders(userID, length, width, height, totalPrice, true, "priced");
        om.createPreOrder(ord);

        ilm.addToItemlist(im.getName(8), im.getDescription(8), im.getLength(8), itemList.remAmount(length).get(0), om.getLatestOrder(), im.getId(im.getName(8)));
        ilm.addToItemlist(im.getName(10), im.getDescription(10), im.getLength(10), itemList.raftAmount(length, width).get(0), om.getLatestOrder(), im.getId(im.getName(10)));
        ilm.addToItemlist(im.getName(11), im.getDescription(11), im.getLength(11), itemList.postAmount(length, width).get(0), om.getLatestOrder(), im.getId(im.getName(11)));
        ilm.addToItemlist(im.getName(15), im.getDescription(15), im.getLength(15), itemList.roofAmount(length, width).get(0), om.getLatestOrder(), im.getId(im.getName(15)));
        ilm.addToItemlist(im.getName(17), im.getDescription(17), 0, roofScrewAmount, om.getLatestOrder(), im.getId(im.getName(17)));
        ilm.addToItemlist(im.getName(19), im.getDescription(19), 0, universalRightAmount, om.getLatestOrder(), im.getId(im.getName(19)));
        ilm.addToItemlist(im.getName(20), im.getDescription(20), 0, universalLeftAmount, om.getLatestOrder(), im.getId(im.getName(20)));
        ilm.addToItemlist(im.getName(22), im.getDescription(22), 0, bracketScrewAmount, om.getLatestOrder(), im.getId(im.getName(22)));
        ilm.addToItemlist(im.getName(23), im.getDescription(23), 0, carriageBoltAmount, om.getLatestOrder(), im.getId(im.getName(23)));
        ilm.addToItemlist(im.getName(24), im.getDescription(24), 0, squareSlicesAmount, om.getLatestOrder(), im.getId(im.getName(24)));
        
        totalPrice = 0;

        return "order";
    }
}
