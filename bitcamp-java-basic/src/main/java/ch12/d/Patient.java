package ch12.d;

public class Patient {
  
  public static final int WOMAN = 1;
  public static final int MAN = 2;
  
  String name;
  int age;
  int height;
  int weight;
  int gender;
  
  public String getString() {
    String s = "name=" + name + ", age=" + age +", height= " +height+", weight=" + weight + ", gender="+gender;
    return s;
  }
  
  public String toString() {
    return String.format("name=%s, age=%d, weight=%d, height=%d, gender=%d", this.name,this.age,this.weight,this.height,this.gender);
  }
  
}
