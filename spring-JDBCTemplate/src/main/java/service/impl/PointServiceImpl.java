/**
 * Copyright (C), 2020-2022, XDU
 * FileName: PointServiceImpl
 * Author: Dingq
 * Date: 2022/5/12 15:36
 * Description:
 */
package service.impl;

import dao.PointDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.Point;
import service.PointService;

import java.util.List;

@Service(value = "pointService")
public class PointServiceImpl implements PointService {

    @Autowired
    private PointDAO pointDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public void transfer(String from, String to, Integer point) {
        pointDAO.updatePoint(-1 * point, from);
//        int temp = 1 / 0;
        pointDAO.updatePoint(point, to);
    }

    @Override
    public List<Point> getPoints() {
        return pointDAO.queryPoints();
    }
}