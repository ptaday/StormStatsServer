/**
 * @author Pushkar Taday
 * SBU ID:114375166
 * Recitation:04
 */

package Homework6;

import java.util.Comparator;

/**
 * This class helps compare precipitation of the storms
 */

public class PrecipitationComparator implements Comparator {

    /**
     * This method overrides the compare method  defined in the comparator class
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
     * This customized method compares the precipitation of two Storm object
     * @param left
     * the storm passed to be compared
     * @param right
     * another storm passed to be compared
     * @return
     */
    public int compare(Storm left,Storm right)
    {
        if(left.getPrecipitation()<right.getPrecipitation())
            return -1;

        else if(left.getPrecipitation()>right.getPrecipitation())
            return 1;

        else
            return 0;
    }


}
