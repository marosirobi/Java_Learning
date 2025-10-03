package Challenge1;

import java.time.LocalDate;
import java.util.*;

public class Student {

    private static long lastStudentId = 1;
    private  final static Random rand = new Random();

    private final long studentId;
    private final int yearEnrolled;
    private final int ageEnrolled;
    private final String gender;
    private final String countryCode;
    private final boolean programmingExperience;
    private final Map<String, CourseEngagement> engagementMap = new HashMap<>();

    public Student(String countryCode, int yearEnrolled, int ageEnrolled, String gender,
                   boolean programmingExperience, Course... courses) {
        studentId = lastStudentId++;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageEnrolled = ageEnrolled;
        this.gender = gender;
        this.programmingExperience = programmingExperience;

        for(Course c : courses){
            addCourse(c, LocalDate.of(yearEnrolled, 1, 1));
        }

    }

    public void addCourse(Course newCourse){
        addCourse(newCourse, LocalDate.now());
    }

    public void addCourse(Course newCourse, LocalDate enrollDate){
        engagementMap.put(newCourse.courseCode(), new CourseEngagement(newCourse, enrollDate, "Enrollment"));
    }

    public long getStudentId() {
        return studentId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public int getAgeEnrolled() {
        return ageEnrolled;
    }

    public String getGender() {
        return gender;
    }

    public boolean hasProgrammingExperience() {
        return programmingExperience;
    }

    public Map<String, CourseEngagement> getEngagementMap() {
        return Map.copyOf(engagementMap);
    }

    public int getYearsSinceEnrolled(){
        return LocalDate.now().getYear() - yearEnrolled;
    }

    public int getAge(){
        return ageEnrolled + getYearsSinceEnrolled();
    }

    public int getMonthsSinceActive(String courseCode){
        CourseEngagement info = engagementMap.get(courseCode);
        return info == null ? 0 : info.getMonthsSinceActive();
    }

    public int getMonthsSinceActive(){
        int inactiveMonths = (LocalDate.now().getYear() - 2014) * 12;
        for(String key : engagementMap.keySet()){
            inactiveMonths = Math.min(inactiveMonths, getMonthsSinceActive(key));
        }
        return inactiveMonths;
    }

    public double getPercentComplete(String courseCode){
        var info = engagementMap.get(courseCode);
        return info == null ? 0 : info.getPercentComplete();
    }

    public void watchLecture(String courseCode, int lectureNumber, int year, int month){
        var activity = engagementMap.get(courseCode);
        if(activity != null){
            activity.watchLecture(lectureNumber, LocalDate.of(year,month, 1));
        }
    }

    private static String getRandomVal(String... data){
        return data[rand.nextInt(data.length)];
    }

    private static Course[] getRandomSelection(Course... courses){
        int courseCount = rand.nextInt(1,courses.length+1);
        List<Course> courseList = new ArrayList<>(Arrays.asList(courses));
        Collections.shuffle(courseList);
        List<Course> selectedCourses = courseList.subList(0, courseCount);
        return selectedCourses.toArray(new Course[0]);
    }

    public static Student getRandomStudent(Course... courses){

        int maxYear = LocalDate.now().getYear() + 1;
        Course[] randomCourses = getRandomSelection(courses);

        Student student = new Student(
                getRandomVal("AU","CA","CN","GB","IN","UA","US"),
                rand.nextInt(2015,maxYear), rand.nextInt(18,90),
                getRandomVal("M","F","U"),
                rand.nextBoolean(),
                randomCourses);
        for(Course c : randomCourses){
            int lecture = rand.nextInt(30, c.lectureCount());
            int year = rand.nextInt(student.yearEnrolled, maxYear);
            int month = rand.nextInt(1,13);
            if(year == (maxYear-1)){
                if(month > LocalDate.now().getMonthValue())
                    month = LocalDate.now().getMonthValue();
            }
            student.watchLecture(c.courseCode(), lecture,year,month);
        }
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", yearEnrolled=" + yearEnrolled +
                ", ageEnrolled=" + ageEnrolled +
                ", gender='" + gender + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", programmingExperience=" + programmingExperience +
                ", engagementMap=" + engagementMap +
                '}';
    }
}
