package univ;

import univ.Degree;

public abstract class GeneralDegree extends Degree {
    protected static final double rqrdNumberOfCredits = 15.00;


    GeneralDegree() { 
        super(); 
    }

    GeneralDegree(String title) {
        super(title);
    }


}
