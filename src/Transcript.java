import univ.Degree;

import java.util.ArrayList;

public class Transcript
{
    private Degree degree;
    private ArrayList<Attempt> completedCourses;
    private ArrayList<Attempt> plannedCourses;

    public Transcript() {
        completedCourses = new ArrayList<>();
        plannedCourses = new ArrayList<>();
        degree = null;
    }

    public void setCompletedCourses(ArrayList<Attempt> completedCourses) {
        if (completedCourses != null) {
            this.completedCourses = completedCourses;
        }
    }

    public void setPlannedCourses(ArrayList<Attempt> plannedCourses) {
        if (plannedCourses != null) {
            this.plannedCourses = plannedCourses;
        }
    }

    public void addCompletedCourse(Attempt completed) {
        if (completed != null && completedCourses != null) {
            completedCourses.add(completed);
        }
    }

    public void addPlannedCourse(Attempt planned) {
        if (planned != null && plannedCourses != null) {
            plannedCourses.add(planned);
        }
    }

    public boolean hasDegree() {
        if (degree != null) {
            return true;
        }
        return false;
    }

    public void setDegree(Degree degree) {
        if (degree != null) {
            this.degree = degree;
        }
    }
}
