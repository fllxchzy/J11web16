package com.bdqn.fx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.fx.dao.NewsDao;
import com.bdqn.fx.dao.TopicDao;
import com.bdqn.fx.entity.News;
import com.bdqn.fx.entity.Topic;
@WebServlet("/GetNewsServlet")
public class GetNewsServlet extends HttpServlet{
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	  NewsDao dao=new NewsDao();
    	  List<News>list=dao.getList();
    	  //这个集合要响应ajx
    	  //
    	  JSONObject obj=new JSONObject();
    	  obj.put("newss", list);
    	  resp.setContentType("application/json;charset=utf-8");
    	  PrintWriter out=resp.getWriter();
    	  out.print(obj);
    	  out.close();
    }
}
