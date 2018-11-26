package univ;

import java.io.Serializable;

public class SEng extends HonoursDegree
{
    public SEng() {
        super("SEng");
    }

    @Override public String toString() {
        String toReturn = " ";
        return toReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (!(o instanceof Degree)) {
            return false;
        }

        SEng seng = (SEng) o;
        if (!(this.title.equals(seng.title))) {
            return false;
        }
        return this.listOfRequiredCourseCodes.equals(seng.listOfRequiredCourseCodes);
    }
}
