package service;

import pojo.Point;

import java.util.List;

public interface PointService {
    void transfer(String from, String to, Integer point);

    List<Point> getPoints();
}
