package businesslayer;

import java.util.ArrayList;
import java.util.List;

public class ItemList {

    private static List<Integer> post = new ArrayList<>();
    private static List<Integer> raft = new ArrayList<>();
    private static List<Integer> rem = new ArrayList<>();
    private static List<Integer> roof = new ArrayList<>();
    private static int postTotal = 0;
    private static int raftTotal = 0;
    private static int remTotal = 0;
    private static int roofTotal = 0;

             //OBS, calculations is based of the biggest items of each category
    /**
     * @param carportLength
     * @param carportWidth
     * @return list
     */
    public static List<Integer> postAmount(int carportLength, int carportWidth) {
        int postRow = 0;
        postRow = (carportLength / 200); //divide by 2 because we want a post for every 2m/200cm, -40 to support the extra hangout

        if (carportWidth <= 800) //max carport width is 8m or 800cm
        {
            postTotal = (postRow * 2) + 2;
        } else {
            int numberOfRows = (carportWidth / 800);
            numberOfRows += 2; //adds 2, because once the width is over 8, middle posts is needed
            postTotal = numberOfRows * postRow;
        }
        post.add(postTotal);
        return post;
    }

    /**
     * @param carportLength
     * @param carportWidth
     * @return list
     */
    public static List<Integer> raftAmount(int carportLength, int carportWidth) {
        Double raftRow = 0.00;
        raftRow = (carportLength / 55.00); //0.55 is length of gap between the rafts
        int raftRowInt = raftRow.intValue();

        if (carportWidth < 600) {
            raftTotal = raftRowInt + 2;
        } else {
            raftTotal = (raftRowInt + 2) * 2;
        }
        raft.add(raftTotal);
        return raft;
    }

    /**
     * @param carportLength
     * @return list
     */
    public static List<Integer> remAmount(int carportLength) {
        //Carport only have 2 sides, no middle posts
        if (carportLength <= 600) {
            remTotal = 2;
        } else {
            remTotal = 4;
        }
        rem.add(remTotal);
        return rem;
    }

    /**
     * @param carportLength
     * @param carportWidth
     * @return list
     */
    public static List<Integer> roofAmount(int carportLength, int carportWidth) {
        Double roofPlate = 0.00;
        roofPlate = (carportLength / 110.00); //1.1 is width of roof plate
        int roofPlateInt = roofPlate.intValue();

        if (carportWidth > 600) {
            roofTotal = (roofPlateInt + 1) * 2;
        } else {
            roofTotal += roofPlateInt + 1; //add +1 because working with int, results in one less because int cuts decimals           
        }
        roof.add(roofTotal);
        return roof;
    }

    /**
     * @return list
     */
    public static List<Integer> getPost() {
        return post;
    }

    /**
     * @return list
     */
    public static List<Integer> getRaft() {
        return raft;
    }

    /**
     * @return list
     */
    public static List<Integer> getRem() {
        return rem;
    }

    /**
     * @return list
     */
    public static List<Integer> getRoof() {
        return roof;
    }

    /**
     * @return PostTotal
     */
    public static int getPostTotal() {
        return postTotal;
    }

    /**
     * @return RaftTotal
     */
    public static int getRaftTotal() {
        return raftTotal;
    }

    /**
     * @return RemTotal
     */
    public static int getRemTotal() {
        return remTotal;
    }

    /**
     * @return RoofTotal
     */
    public static int getRoofTotal() {
        return roofTotal;
    }
}
