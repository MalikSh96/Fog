package businesslayer;

import datalayer.InventoryMapper;
import datalayer.ItemlistMapper;
import datalayer.OrderMapper;
import datalayer.UserMapper;

public class Constants {

    public static final BusinessFacade BF = new BusinessFacade();
    public static final OrderMapper OM = new OrderMapper();
    public static final InventoryMapper IM = new InventoryMapper();
    public static final ItemlistMapper ILM = new ItemlistMapper();
    public static final UserMapper UM = new UserMapper();
    public static final UniversalExceptions UEX = new UniversalExceptions();

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

    public static UniversalExceptions getUEX() {
        return UEX;
    }

    
}
