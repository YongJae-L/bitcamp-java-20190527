package ch14.a;

public class Score2 extends Score {
  protected int music;
  protected int art;
  
  // 오버라이딩(overriding)?
  // => 상속 받은 메서드를 서브 클래스의 역할에 맞게 재정의하는 문법
  // => 상속 받은 메서드와 똑 같은 시그너처로 메서드를 정의한다.
  
  @Override // 컴파일러에게 상속 받은 메서드를 재정의 한다는 것을 알려준다. 
            // 만약 개발자가 메서드 이름을 다르게 사용하거나 파라미터를 잘못 선언하면
            // 컴파일러가 즉시 알려준다.
  public void compute() { //접근범위 상단에서 default 일 경우 하단에서 protected 좁히는건 불가능 넓히는건 가능
    this.sum = this.kor + this.eng + this.math + this.music + this.art;
    this.aver = this.sum / 5f;
  }
}
