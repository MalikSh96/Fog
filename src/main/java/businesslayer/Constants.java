package businesslayer;

import datalayer.InventoryMapper;
import datalayer.ItemlistMapper;
import datalayer.OrderMapper;
import datalayer.UserMapper;

/**
 *
 * @author malik
 */
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

    /**
     * @return OrderMapper
     */
    public static OrderMapper getOM() {
        return OM;
    }

    /**
     * @return InventoryMapper
     */
    public static InventoryMapper getIM() {
        return IM;
    }

    /**
     * @return itemListMapper
     */
    public static ItemlistMapper getILM() {
        return ILM;
    }

    /**
     * @return roofScrewAmount
     */
    public static int getROOFSCREWAMOUNT() {
        return ROOFSCREWAMOUNT;
    }

    /**
     * @return UniversalRightAmount
     */
    public static int getUNIVERSALRIGHTAMOUNT() {
        return UNIVERSALRIGHTAMOUNT;
    }

    /**
     * @return UniversalLeftAmount
     */
    public static int getUNIVERSALLEFTAMOUNT() {
        return UNIVERSALLEFTAMOUNT;
    }

    /**
     * @return BracketScrewAmount
     */
    public static int getBRACKETSCREWAMOUNT() {
        return BRACKETSCREWAMOUNT;
    }

    /**
     * @return CARRIAGEBOLTAMOUNT
     */
    public static int getCARRIAGEBOLTAMOUNT() {
        return CARRIAGEBOLTAMOUNT;
    }

    /**
     * @return SQUARESLICESAMOUNT
     */
    public static int getSQUARESLICESAMOUNT() {
        return SQUARESLICESAMOUNT;
    }

    /**
     * @return UserMapper
     */
    public static UserMapper getUM() {
        return UM;
    }

    /**
     * @return BusinessFacade
     */
    public static BusinessFacade getBf() {
        return BF;
    }

    /**
     * @return UniversalExceptions
     */
    public static UniversalExceptions getUEX() {
        return UEX;
    }
}
