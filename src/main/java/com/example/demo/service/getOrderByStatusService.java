package com.example.demo.service;

import com.example.demo.mapper.getAllOrderByStatusMapper;
import com.example.demo.mapper.getOrderByStatusMapper;
import com.example.demo.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class getOrderByStatusService {

    public static final String allOrder = "0";
    public static final String ongongOrder = "1";
    public static final String finishOrder = "2";

    @Autowired
    private getAllOrderByStatusMapper getAllOrderByStatusMapper;

    @Autowired
    private getOrderByStatusMapper getOrderByStatusMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());



    public ArrayList<Order> getOrderByStatus(String nickName,String order_status){
        if (getParams(nickName,order_status) == false){
            logger.warn("getOrderByStatus参数方法错误");
            return null;
        }

        ArrayList<Order> orderList = new ArrayList<Order>();

        if (order_status.equals(allOrder)){
            //获取全部 order_status为0
            orderList = getAllOrderByStatusMapper.getAllOrderByStatus(nickName);
        } else {
            orderList = getOrderByStatusMapper.getOrderByStatus(nickName,order_status);
        }


        if(orderList == null){
            logger.warn("getOrderByStatus方法获取数据为空");
        }
        return orderList;
    }

    public boolean getParams(String nickName,String order_status){
        if (nickName == null || nickName.length() > 30 || order_status == null){
            return false;
        }
        if (!order_status.equals(allOrder) && !order_status.equals(ongongOrder) && !order_status.equals(finishOrder)){
            return false;
        }

        return true;
    }
}
