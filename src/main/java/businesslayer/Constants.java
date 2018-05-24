package businesslayer;

import datalayer.DataFacade;
import datalayer.InventoryMapper;
import datalayer.ItemlistMapper;
import datalayer.OrderMapper;
import datalayer.UserMapper;

public class Constants {
    
    ItemList itemList = new ItemList();
    public static final BusinessFacade BF = new BusinessFacade();
    public static final OrderMapper OM = new OrderMapper();
    public static final InventoryMapper IM = new InventoryMapper();
    public static final ItemlistMapper ILM = new ItemlistMapper();
    public static final UserMapper UM = new UserMapper();

    
        //hardcoding of misc carport stuff
    public static final int ROOFSCREWAMOUNT = 2;
    public static final int UNIVERSALRIGHTAMOUNT = 20;
    public static final int UNIVERSALLEFTAMOUNT = 20;
    public static final int BRACKETSCREWAMOUNT = 2;
    public static final int CARRIAGEBOLTAMOUNT = 14;
    public static final int SQUARESLICESAMOUNT = 14;

    public static OrderMapper getOM() {
        return OM;
    }

    public ItemList getItemList() {
        return itemList;
    }

    public static InventoryMapper getIM() {
        return IM;
    }

    public static ItemlistMapper getILM() {
        return ILM;
    }

    public static int getROOFSCREWAMOUNT() {
        return ROOFSCREWAMOUNT;
    }

    public static int getUNIVERSALRIGHTAMOUNT() {
        return UNIVERSALRIGHTAMOUNT;
    }

    public static int getUNIVERSALLEFTAMOUNT() {
        return UNIVERSALLEFTAMOUNT;
    }

    public static int getBRACKETSCREWAMOUNT() {
        return BRACKETSCREWAMOUNT;
    }

    public static int getCARRIAGEBOLTAMOUNT() {
        return CARRIAGEBOLTAMOUNT;
    }

    public static int getSQUARESLICESAMOUNT() {
        return SQUARESLICESAMOUNT;
    }    

    public static UserMapper getUM() {
        return UM;
    }

    public static BusinessFacade getBf() {
        return BF;
    }
    
}
