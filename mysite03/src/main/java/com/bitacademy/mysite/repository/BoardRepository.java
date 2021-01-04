package com.bitacademy.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitacademy.mysite.vo.BoardVo;
import com.bitacademy.mysite.vo.GuestbookVo;
import com.bitacademy.mysite.vo.PageNumberVo;
import com.bitacademy.mysite.vo.UserVo;

@Repository
public class BoardRepository {

	public List<BoardVo> findAll(PageNumberVo pageNumberVo) {
		List<BoardVo> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql =

					"select a.no, a.title, date_format(a.reg_date, '%Y-%m-%d / %H시 %i분 %S초'), a.hit, a.user_no, b.name as username, a.good, a.not_good"
							+ ", a.group_no, a.order_no, a.depth" + " from board a, user b" + " where a.user_no = b.no"
							+ " order by a.group_no desc, a.order_no asc" + " limit ?, ?";
			pstmt = conn.prepareStatement(sql);

			Integer currentPage = (pageNumberVo.getCurrentPage() - 1) * 5;
			Integer pageSize = pageNumberVo.getPageSize();
			pstmt.setInt(1, currentPage);
			pstmt.setInt(2, pageSize);
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



	public boolean createNewArticle(BoardVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into board (no, title, contents, hit, reg_date, group_no, order_no, depth, good, not_good, user_no)\r\n"
					+ "Values\r\n" + "(null,?,?,0,now(),\r\n"
					+ "(SELECT IFNULL(MAX(b.group_no) + 1, 1) FROM board b),\r\n" + "1,\r\n" + "1,\r\n" + "0,\r\n"
					+ "0,\r\n" + "?);";

			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, String.valueOf(vo.getUserNo()));

			// 5. sql문 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
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

		return result;
	}

	public BoardVo findContentsFromNo(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql =

					"select a.title, a.contents, date_format(a.reg_date, '%Y-%m-%d / %H시 %i분 %S초') as t, a.hit, a.good, a.not_good, b.name as username,\r\n"
							+ "a.group_no, a.order_no, \r\n" + "b.no \r\n" + "from board a, user b\r\n"
							+ "where a.user_no = b.no and a.no = ?";

			pstmt = conn.prepareStatement(sql);

			Long ranknumber = vo.getNo();
			pstmt.setLong(1, ranknumber);

			// 4. 바인딩

			// 5. sql문 실행
			rs = pstmt.executeQuery();

			// 6. 데이터 가져오기
			while (rs.next()) {

				String title = rs.getString(1);
				String contents = rs.getString(2);
				String regDate = rs.getString(3);
				Long hit = rs.getLong(4);
				int good = rs.getInt(5);
				int notGood = rs.getInt(6);
				String userName = rs.getString(7);
				Long groupNo = rs.getLong(8);
				int orderNo = rs.getInt(9);
				Long userNo = rs.getLong(10);

				vo.setTitle(title);
				vo.setContents(contents);
				vo.setRegDate(regDate);
				vo.setHit(hit);
				vo.setGood(good);
				vo.setNotGood(notGood);
				vo.setUserNo(userNo);
				vo.setUserName(userName);
				vo.setGroupNo(groupNo);
				vo.setOrderNo(orderNo);

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

		return vo;
	}

	public boolean modifyArticle(BoardVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "update board\r\n" + "set title =?, contents =?\r\n" + "where no = ?;";

			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, String.valueOf(vo.getNo()));

			// 5. sql문 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
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

		return result;
	}

	public boolean createNewReply(BoardVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			// depth의 최대치는 3
			String sql = "insert into board (no, title, contents, hit, reg_date, group_no, order_no, depth, good, not_good, user_no)\r\n"
					+ "Values\r\n" + "(null,?,?,0,now(),\r\n" + "(SELECT c.group_no from board c where no = ?),\r\n"
					+ "(SELECT IFNULL(MAX(b.order_no) + 1, 1) FROM board b where group_no = (SELECT d.group_no from board d where no = ?)),\r\n"
					+ "(SELECT LEAST((SELECT IFNULL(MAX(b.depth) + 1, 1) FROM board b where group_no = (SELECT e.group_no from board e where no = ?)), 3)),\r\n"
					+ "0,\r\n" + "0,\r\n" + "?)\r\n" + ";";

			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());

			// no of articleBeingCommented
			String strNABC = String.valueOf(vo.getNo());
			pstmt.setString(3, strNABC);
			pstmt.setString(4, strNABC);
			pstmt.setString(5, strNABC);

			pstmt.setString(6, String.valueOf(vo.getUserNo()));

			// 5. sql문 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
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

		return result;
	}

	public boolean deleteArticle(UserVo userVo, BoardVo boardVo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql =

					"delete from board\r\n" + "where no = ? \r\n"
							+ "and user_no = (select no from user where user.no = board.user_no and password=?)";

			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setLong(1, boardVo.getNo());
			pstmt.setString(2, userVo.getPassword());

			// 5. sql문 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
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

		return result;
	}

	public boolean addViewCount(BoardVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "update board\r\n" + "set hit = hit+1\r\n" + "where no = ?";

			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, String.valueOf(vo.getNo()));

			// 5. sql문 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
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

		return result;
	}

	public boolean addGoodCount(BoardVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "update board\r\n" + "set good = good+1\r\n" + "where no = ?";

			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, String.valueOf(vo.getNo()));

			// 5. sql문 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
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

		return result;
	}

	public boolean addNotGoodCount(BoardVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "update board\r\n" + "set not_good = not_good+1\r\n" + "where no = ?";

			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, String.valueOf(vo.getNo()));

			// 5. sql문 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				// 3. 자원정리
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

		return result;
	}

	public List<BoardVo> findWithKeyword(String kwd) {
		List<BoardVo> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql =

					"select a.no, a.title, date_format(a.reg_date, '%Y-%m-%d / %H시 %i분 %S초'), a.hit, a.user_no, b.name as username,  a.good, a.not_good,\r\n" + 
					"a.group_no, a.order_no, a.depth\r\n" + 
					"from board a, user b\r\n" + 
					"WHERE (a.title REGEXP ?\r\n" + 
					"or a.contents REGEXP ?\r\n" + 
					"or b.name REGEXP ?)"
					+ "and a.user_no = b.no";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, kwd);
			pstmt.setString(2, kwd);
			pstmt.setString(3, kwd);

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
			String url = "jdbc:mysql://192.168.200.191:3306/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}
	
	
	
}







