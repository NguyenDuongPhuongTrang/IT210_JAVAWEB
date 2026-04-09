package miniproject.ss06.model;

import miniproject.ss06.enums.LevelCourse;

public class Course {
    private int id;
    private String CourseName;
    private LevelCourse levelCourse;
    private String description;
    private String teacherName;
    private String duration;
    private double price;
    private boolean isFull;

    public Course() {
    }

    public Course(int id, String courseName, LevelCourse levelCourse, String description, String teacherName, String duration, double price, boolean isFull) {
        this.id = id;
        CourseName = courseName;
        this.levelCourse = levelCourse;
        this.description = description;
        this.teacherName = teacherName;
        this.duration = duration;
        this.price = price;
        this.isFull = isFull;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public LevelCourse getLevelCourse() {
        return levelCourse;
    }

    public void setLevelCourse(LevelCourse levelCourse) {
        this.levelCourse = levelCourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
