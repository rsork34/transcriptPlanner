import java.util.ArrayList;

public class Transcript
{
    private ArrayList<Attempt> completedCourses;
    private ArrayList<Attempt> plannedCourses;

    public Transcript() {
        completedCourses = new ArrayList<>();
        plannedCourses = new ArrayList<>();
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
}
