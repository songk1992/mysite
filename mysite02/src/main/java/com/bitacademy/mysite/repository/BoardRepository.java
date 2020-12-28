package com.bitacademy.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.PageNumberVo;

public class BoardRepository {

	public List<BoardVo> findAll(PageNumberVo pageNumberVo){
			List<BoardVo> list = new ArrayList<>();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = getConnection();

				// 3. SQL 준비
				String sql = 
						
						"select a.no, a.title, date_format(a.reg_date, '%Y-%m-%d / %H시 %i분 %S초'), a.hit, a.user_no, b.name as username, a.good, a.not_good"
						+", a.group_no, a.order_no, a.depth"
						+" from board a, user b"
						+" where a.user_no = b.no"
						+" order by a.group_no desc, a.order_no asc"
						+" limit ?, ?";
				pstmt = conn.prepareStatement(sql);
				
				Integer pageNumber = (pageNumberVo.getPageNumber() - 1) * 5;
				Integer pageAmountOfArticles = pageNumberVo.getPageAmountOfArticles();
				pstmt.setInt(1, pageNumber);
				pstmt.setInt(2, pageAmountOfArticles);
				// 4. 바인딩

				// 5. sql문 실행
				rs = pstmt.executeQuery();

				
				
				
				// 6. 데이터 가져오기
				while (rs.next()) {
					

					
					Long no = rs.getLong(1);
					String title = rs.getString(2);
					String regDate = rs.getString(3);
					Long hit = rs.getLong(4);
					Long userNo = rs.getLong(5);
					String userName = rs.getString(6);
					int good = rs.getInt(7);
					int notGood = rs.getInt(8);
					
					Long groupNo = rs.getLong(9);
					int orderNo = rs.getInt(10);
					int depth = rs.getInt(11);
					

					BoardVo vo = new BoardVo();
					vo.setNo(no);
					vo.setTitle(title);
					vo.setRegDate(regDate);
					vo.setHit(hit);
					vo.setUserNo(userNo);
					vo.setUserName(userName);
					vo.setGood(good);
					vo.setNotGood(notGood);
					vo.setGroupNo(groupNo);
					vo.setOrderNo(orderNo);
					vo.setDepth(depth);
					
					list.add(vo);
				}

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				try {
					// 3. 자원정리
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return list;
		}
	
	
	private Connection getConnection() throws SQLException {
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
