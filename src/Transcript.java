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

    public String getDegreeTitle() {
        if (degree == null) {
            return null;
        }

        return degree.getDegreeTitle();
    }

    public double getGPA() {
        double total = 0;
        int count = 0;

        if (completedCourses.isEmpty()) {
            return -1;
        }

        for (Attempt a : completedCourses) {
            try {
                total += Double.parseDouble(a.getAttemptGrade());
                count++;
            }
            catch (Exception e) {
                return -1;
            }
        }

        return total / count;
    }

    public double getCreditsCompleted() {
        double credits = 0;

        for (Attempt a : completedCourses) {
            try {
                // Completed course was passed
                if (Double.parseDouble(a.getAttemptGrade())>= 50) {
                    credits += a.getCourseAttempted().getCourseCredit();
                }
            }
            catch (Exception e) {
                return -1;
            }
        }
        return credits;
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

    public void removePlannedCourse(String courseCode) {
        for (Attempt a : plannedCourses) {
            if (a.getCourseCode().equals(courseCode)) {
                plannedCourses.remove(a);
                return;
            }
        }
    }

    public void removeCompleteCourse(String courseCode) {
        for (Attempt a : completedCourses) {
            if (a.getCourseCode().equals(courseCode)) {
                completedCourses.remove(a);
                return;
            }
        }
    }

    public void updateCompletedGrade(String courseCode, String grade) {
        // Error checking
        if (courseCode == null || grade == null) {
            return;
        }
        else if (courseCode.isEmpty() || grade.isEmpty()) {
            return;
        }

        // Course is found, update grade and return
        for (Attempt a : completedCourses) {
            if (a.getCourseCode().equals(courseCode)) {
                a.setGrade(grade);
                return;
            }
        }
    }

    public void updatePlannedGrade(String courseCode, String grade) {
        // Error checking
        if (courseCode == null || grade == null) {
            return;
        }
        else if (courseCode.isEmpty() || grade.isEmpty()) {
            return;
        }

        // Course is found, update grade and return
        for (Attempt a : plannedCourses) {
            if (a.getCourseCode().equals(courseCode)) {
                a.setGrade(grade);
                return;
            }
        }
    }

    public ArrayList<Attempt> getCompletedCourses() {
        return completedCourses;
    }

    public ArrayList<Attempt> getPlannedCourses() {
        return plannedCourses;
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
