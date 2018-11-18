package univ;

import java.io.FileWriter;
import java.util.*;

public class CourseCatalog {

    private ArrayList<Course> courseCatalog;

    public CourseCatalog() {
        this.courseCatalog = new ArrayList<>();
        hardCoded();
    }

    protected void setCourseCatalog(ArrayList<Course> courseCatalog) {
        this.courseCatalog = courseCatalog;
    }

    public ArrayList<Course> getCourseCatalog() {
        return this.courseCatalog;
    }

    public void addCourse(Course toAdd) {
        for (Course c : this.courseCatalog) {
            if (c.equals(toAdd)) {
                return;
            }
        }
        courseCatalog.add(toAdd);
    }

    public void removeCourse(Course toRemove) {
        for (Course c : this.courseCatalog) {
            if (c.equals(toRemove)) {
                this.courseCatalog.remove(c);
                return;
            }
        }
    }

    public Course findCourse(String courseCode) {
        for (Course c : this.courseCatalog) {
            if (c.getCourseCode().equals(courseCode)) {
                return c;
            }
        }
        return null;
    }

    public Boolean isEmpty() { return courseCatalog.isEmpty(); }

    public void saveCatalog() {
        try (FileWriter PoSData = new FileWriter("BootstrapCatalog.txt")) {
            String fileLine;
            for (Course c : this.courseCatalog) {
                fileLine = c.toFile();
                PoSData.write(fileLine);
            }
            PoSData.close();
            System.out.println("Course Catalog saved to 'BootstrapCatalog.txt'.");
        } catch (Exception e) {
            System.out.println("Failed to successfully save state for Plan Of Study.");
        }
    }

    private void hardCoded() {
        Course c1 = new Course("CIS 2500", "INT PROGRAMMING", "In progress", "B", 0.5);
        Course c2 = new Course("CIS 2750", "hard stuff", "planned", "w", 0.75);
        Course c3 = new Course("CIS 1500", "easy stuff", "In progress", "B", 0.5);
        Course c4 = new Course("CIS 3110", "ALGOS", "Planned", "F", 0.5);
    }

    /*public void initializeCatalog(String filename) {
        try {
            FileReader PoSData = new FileReader(filename);
            int filePointer, index = 0;
            String fileLine = "";
            String[][] fileContents = new String[50][4]; //up to 50 courses per file should be sufficient

            while ((filePointer = PoSData.read()) != -1) {
                if (!String.valueOf((char) filePointer).matches("\n") && !String.valueOf((char) filePointer).matches("\\?")) {

                    fileLine += (char) filePointer;

                } else if (String.valueOf((char) filePointer).matches("\n") || String.valueOf((char) filePointer).matches("\\?")) {
                    ArrayList<Course> preReqList = new ArrayList<>();
                    ArrayList<String> preReqListString = new ArrayList<>();
                    fileContents[index] = fileLine.split(",");

                    if (fileContents[index].length == 4) {
                        if (fileContents[index][3].length() > 3) {
                            if (fileContents[index][3].contains(":")) {
                                String[] prereques = fileContents[index][3].split(":");
                                preReqListString.addAll(Arrays.asList(prereques));
                            } else {
                                preReqListString.add(fileContents[index][3]);
                            }

                            for (String s : preReqListString) {
                                Course preReq = new Course();
                                preReq.setCourseCode(s);
                                preReqList.add(preReq);
                            }
                        }
                    }
                    fileLine = "";

                    Course fileCourse = new Course();
                    fileCourse.setCourseCode(fileContents[index][0]);
                    fileCourse.setCourseTitle(fileContents[index][2]);
                    fileCourse.setCourseCredit(Double.parseDouble(fileContents[index][1]));
                    fileCourse.setPrerequisites(preReqList);

                    this.courseCatalog.add(fileCourse);
                    index++;
                }
            }

            for (Course catalogCourse : this.courseCatalog) {
                if (!catalogCourse.getPrerequisites().isEmpty()) {
                    ArrayList<Course> cat = catalogCourse.getPrerequisites();
                    ListIterator<Course> iterPre = cat.listIterator();
                    while (iterPre.hasNext()) {
                        Course preReq = iterPre.next();
                        for (Course containsCode : this.courseCatalog) {
                            if (containsCode.getCourseCode().equals(preReq.getCourseCode())) {
                                Course newC = new Course(containsCode);
                                iterPre.remove();
                                iterPre.add(newC);
                                break;
                            }
                        }
                    }
                    catalogCourse.setPrerequisites(cat);
                }
            }
            System.out.println("Course Catalog initialized.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CourseCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        if (this.courseCatalog != null) {
            toString.append("Course Catalog: ");
            for (Course c : this.courseCatalog) {
                toString.append(c.toString());
            }
            toString.append(System.getProperty("line.separator"));
        }
        return toString.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof CourseCatalog)) {
            return false;
        }

        ArrayList<Course> courseCat = ((CourseCatalog) o).courseCatalog;

        return this.courseCatalog.equals(courseCat);
    }
}
