package ua.kiyv.training.library.controller.TestParentChild;

public class Parent {
    private String eyesColor;
    private String hairColor;
    private Integer age;
    private Integer height;

    public Parent(String eyesColor, String hairColor, Integer age, Integer height) {
        this.eyesColor = eyesColor;
        this.hairColor = hairColor;
        this.age = age;
        this.height = height;
    }

    public String getEyesColor() {
        return eyesColor;
    }

    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
