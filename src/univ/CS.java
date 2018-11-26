package univ;

public class CS extends HonoursDegree
{
    public CS() {
        super("CS");
    }

    @Override public String toString() {
        String toReturn = " ";
        return toReturn;
    }

    @Override public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (!(o instanceof Degree)) {
            return false;
        }

        CS cs = (CS) o;
        if (!(this.title.equals(cs.title))) {
            return false;
        }
        return this.listOfRequiredCourseCodes.equals(cs.listOfRequiredCourseCodes);
    }
}
