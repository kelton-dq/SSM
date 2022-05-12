package dao;

import pojo.Point;

import java.util.List;

public interface PointDAO {

    List<Point> queryPoints();

    void updatePoint(Integer point, String name);
}
