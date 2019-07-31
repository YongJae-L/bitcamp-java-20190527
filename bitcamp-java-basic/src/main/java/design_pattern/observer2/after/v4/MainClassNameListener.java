package design_pattern.observer2.after.v4;

public class MainClassNameListener implements CharacterListener{

  StringBuffer line = new StringBuffer();
  String mainClassName = null;
  
  @Override
  public void readed(int ch) {
    if (ch == '\n' ) {
      if (line.indexOf("mainClassName") != -1) {
      int i = line.indexOf("\"");
      if(i != -1) {
        mainClassName = line.substring(i+1, line.indexOf("\"",i+1));
      }
      i = line.indexOf("'");
      if(i != -1) {
        mainClassName = line.substring(i+1, line.indexOf("'",i+1));
      }
      }
      line.setLength(0);
    } else {
      line.append((char)ch);
    }
    
  }

  @Override
  public void displayResult() {
    System.out.printf("mainClassName : %s\n", mainClassName);
    
  }

}
