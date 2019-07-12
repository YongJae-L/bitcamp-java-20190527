package ch12.d;

public class Patient2 {
  
  public static final int WOMAN = 1;
  public static final int MAN = 2;
  
  String name;
  private int age;
  private int height;
  private int weight;
  private int gender;

  public String getName() {
    return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getAge(int age) {
    return age;
  }

  public void setAge(int age) {
    if(age>0 && age<150)
      this.age = age;
    else
      throw new RuntimeException("나이가 유효하지 않습니다!");
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    if(height > 1 && height <300)
      this.height = height;
    else
      throw new RuntimeException("키값이 유효하지 않습니다!");
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    if(weight>0 && weight<500)
      this.weight = weight;
    else
      throw new RuntimeException("몸무게가 유효하지 않습니다!");
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    if(gender > 0 && gender <3)
      this.gender = gender;
    else
      throw new RuntimeException("1~2의 범위에서 입력해주세요!");
  }

  public String getString() {
    String s = "name=" + name + ", age=" + age +", height= " +height+", weight=" + weight + ", gender="+gender;
    return s;
  }
  
  public String toString() {
    return String.format("name=%s, age=%d, weight=%d, height=%d, gender=%d", this.name,this.age,this.weight,this.height,this.gender);
  }
  
}
