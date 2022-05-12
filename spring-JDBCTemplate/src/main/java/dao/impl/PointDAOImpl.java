/**
 * Copyright (C), 2020-2022, XDU
 * FileName: PointDAOImpl
 * Author: Dingq
 * Date: 2022/5/12 15:35
 * Description:
 */
package dao.impl;

import dao.PointDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pojo.Point;

import java.util.List;

@Repository(value = "pointDAO")
public class PointDAOImpl implements PointDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Point> queryPoints() {
        RowMapper<Point> rowMapper = new BeanPropertyRowMapper<>(Point.class);
        List<Point> pointList = jdbcTemplate.query("select * from t_point", rowMapper);
        return pointList;
    }

    @Override
    public void updatePoint(Integer point, String name) {
        jdbcTemplate.update("update t_point set point = point + ? where `name` = ?", point, name);
    }
}