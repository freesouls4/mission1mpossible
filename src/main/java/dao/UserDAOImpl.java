package dao;

import org.apache.ibatis.session.SqlSession;

import dto.User;
import util.MybatisSqlSessionFactory;

public class UserDAOImpl implements UserDAO {

	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public void insertUser(User user) throws Exception {
		sqlSession.insert("mapper.user.insertUser", user);
		sqlSession.commit();
	}

	@Override
	public User selectUser(String userId) throws Exception {
		User user = sqlSession.selectOne("mapper.user.selectUser", userId);
		return user;
	}

}
