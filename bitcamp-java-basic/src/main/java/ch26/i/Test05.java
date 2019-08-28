// 트랜잭션 다루기 - Mybatis + Connection 으로 트랜잭션 제어하기
package ch26.i;

import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test05 {
  static DataSource dataSource;
  public static void main(String[] args) throws Exception {
    
    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/i/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    // SqlSessionFactory로 SqlSession을 만들 때 Connection 객체를 전달할 수 있다.
    // 이 커넥션 객체를 관리해줄 커넥션풀을 준비한다.
    dataSource = new DataSource("org.mariadb.jdbc.Driver",
        "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111");
    
    try {
      dataSource.getConnection().setAutoCommit(false);
  insert1(sqlSessionFactory);
  insert2(sqlSessionFactory);
      ((TxConnection)dataSource.getConnection()).realCommit();
    } catch (Exception e) {
      ((TxConnection)dataSource.getConnection()).realRollback();
    }
    printList(sqlSessionFactory);
  }

  static void insert1(SqlSessionFactory sqlSessionFactory) throws Exception {
    // SqlSession이 사용할 커넥션 객체를 준비한다.
    // => DataSource는 같은 스레드에 대해 같은 커넥션을 리턴한다.
    Connection con = dataSource.getConnection();
    SqlSession sqlSession = sqlSessionFactory.openSession(con);
    
    sqlSession.insert("board.insert", new Board()
          .setTitle("a21")
          .setContents("내용21"));
    sqlSession.close();
  }
  
  static void insert2(SqlSessionFactory sqlSessionFactory) throws Exception {
    // SqlSession이 사용할 커넥션 객체를 준비한다.
    // => DataSource는 같은 스레드에 대해 같은 커넥션을 리턴한다.
    Connection con = dataSource.getConnection();
    SqlSession sqlSession = sqlSessionFactory.openSession(con);
    
    Board board = new Board();
    board.setTitle("a22");
    board.setContents("내용22");
    
    sqlSession.insert("board.insert", board);
    //sqlSession.commit();
    sqlSession.close();
  }
  
  static void printList(SqlSessionFactory sqlSessionFactory) throws Exception {
    Connection con = dataSource.getConnection();
    SqlSession sqlSession = sqlSessionFactory.openSession(con);
    List<Board> boards = sqlSession.selectList("board.select");
    for (Board b : boards) {
      System.out.println(b);
    }
    sqlSession.close();
  }
}