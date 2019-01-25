package com.bdqn.fx.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.fx.entity.News;
import com.bdqn.fx.entity.Topic;

public class NewsDao extends BaseDao {
	public List<News> getList() {
		ResultSet rs = executeQuery("select *from new_category", null);
		List<News> list = new ArrayList<>();
		try {
			while (rs.next()) {
				News n = new News();
				n.setNid(rs.getInt("id"));
				n.setNtitle(rs.getString("title"));
				n.setNauthor(rs.getString("autor"));
				n.setNcreatedate(rs.getDate("createdate"));
				list.add(n);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
