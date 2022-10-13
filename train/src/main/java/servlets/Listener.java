package servlets;

import entities.Food;
import entities.Order;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Listener implements HttpSessionAttributeListener {

    public static List<Integer> orderList=new LinkedList<>();


    public static Map<String,List<Food>> busket=new HashMap<>();

    public static Map<String,List<Food>> getBusket(){
        return busket;
    }

    public static List<Integer> getOrderList(){
        return orderList;
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if(event.getName().equals("addFood")){
            if(!busket.containsKey(event.getSession().getId())){
                List<Food> n=new LinkedList<>();
                n.add((Food) event.getValue());
                busket.put(event.getSession().getId(),n);
            }else{
                busket.get(event.getSession().getId()).add((Food) event.getValue());
            }
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        HttpSessionAttributeListener.super.attributeReplaced(event);
    }

}
