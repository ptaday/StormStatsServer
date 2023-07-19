/**
 * @author Pushkar Taday
 */


import java.util.Comparator;

/**
 * This class helps compare wind Speed of the storms
 */

public class WindSpeedComparator implements Comparator {

    /**
     * This method overrides the compare methods of the Comparator class
     * @param o1
     * object passed to be compared
     * @param o2
     * object passed to be compared
     * @return
     * int value after comparing
     */

    @Override
    public int compare(Object o1, Object o2) {

        Storm left= (Storm)o1;
        Storm right= (Storm)o2;

        int comparedValue=compare(left,right);

        return comparedValue;

    }

    /**
     * This customized method compares wind speeds of the two Storm object passed
     * @param left
     * the storm passed to be compared
     * @param right
     * another storm passed to be compared
     * @return
     */

    public int compare(Storm left,Storm right)
    {
       if(left.getWindSpeed()<right.getWindSpeed())
           return -1;

       else if(left.getWindSpeed()>right.getWindSpeed())
           return 1;

       else
           return 0;
    }


}
