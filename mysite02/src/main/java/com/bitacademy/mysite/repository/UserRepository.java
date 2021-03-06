package com.bitacademy.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bitacademy.mysite.vo.UserVo;

public class UserRepository {
	
	
	
	public UserVo findByEmailAndPassword(UserVo vo) {
		UserVo userVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			// 3. SQL 준비
			String sql =
				" select no, name" +
				"   from user" +
				"  where email=?" +
				"    and password=?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getPassword());
			
			// 5. sql문 실행
			rs = pstmt.executeQuery();
			
			// 6. 데이터 가져오기
			if(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				
				userVo = new UserVo();
				userVo.setNo(no);
				userVo.setName(name);
				
				
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return userVo;
	}
	
	public UserVo findEmailAndGender(UserVo vo) {
		UserVo userVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			
			// TODO : 보안상 문제 있음
			// 3. SQL 준비
			String sql =
				"select no, email, gender, name\r\n" + 
				"from user\r\n" + 
				"where no = ? and name = ?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getName());
			
			
			// 5. sql문 실행
			rs = pstmt.executeQuery();
			
			// 6. 데이터 가져오기
			if(rs.next()) {
				long no = rs.getLong(1);
				String email = rs.getString(2);
				String gender = rs.getString(3);
				String name = rs.getString(4);
				
				userVo = new UserVo();
				userVo.setNo(no);
				userVo.setEmail(email);
				userVo.setGender(gender);
				userVo.setName(name);
				
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return userVo;
	}
	
	public boolean insert(UserVo userVo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			
			// 3. SQL 준비
			String sql =
					" insert" +
					"   into user" +
					" values (null, ?, ?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setString(1, userVo.getName());
			pstmt.setString(2, userVo.getEmail());
			pstmt.setString(3, userVo.getPassword());
			pstmt.setString(4, userVo.getGender());
			
			// 5. sql문 실행
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return result;		
	}
	
	
	public UserVo updateByEmailAndPassword(UserVo userVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			
			// TODO : 보안상 문제 있음
			// 3. SQL 준비
			String sql =
				"UPDATE user\r\n" + 
				"SET name = ?,  gender = ?, email = ?\r\n" + 
				"WHERE no = ? and password = ?;";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 바인딩
			pstmt.setString(1, userVo.getName());
			pstmt.setString(2, userVo.getGender());
			pstmt.setString(3, userVo.getEmail());
			pstmt.setLong(4, userVo.getNo());
			pstmt.setString(5, userVo.getPassword());
			
			// 5. sql문 실행
			rs = pstmt.executeQuery();
			
			// 6. 데이터 가져오기
			if(rs.next()) {
				long no = rs.getLong(1);
				String email = rs.getString(2);
				String gender = rs.getString(3);
				String name = rs.getString(4);
				
				userVo = new UserVo();
				userVo.setNo(no);
				userVo.setEmail(email);
				userVo.setGender(gender);
				userVo.setName(name);
				
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return userVo;
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기
			String url = "jdbc:mysql://192.168.200.200:3307/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return conn;
	}


}