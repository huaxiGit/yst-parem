package com.yst.Controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-03-09 15:45:59
 */
@ServerEndpoint("/websocket")
@Component
public class WebController {
    static Log log = LogFactory.getLog(WebController.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebController> webSocketSet = new CopyOnWriteArraySet<WebController>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //接受用户id
    private String userId;

    @OnOpen
    public void onOpen(Session session, @PathParam("serviceId") String serviceId){
        this.session = session;
        //在线人数加1
        addOnlineCount();
        //加入到set中
        webSocketSet.add(this);
        log.info("有新连接加入" + userId + "在线人数" );
        this.userId = serviceId;
        try {
          //  sendMessage("连接成功");
            log.info("连接modbus成功");
        }catch (Exception e){
            log.error("连接异常");
        }

    }

    @OnClose
    public void onClose( ){
        //从set中删除
        webSocketSet.remove(this);
        //在线人数减一
        subOnlineCount();
        log.info("有连接关闭");
    }

    @OnMessage
    public void onMessage(String message){
        log.info("收到" + "的消息" + message);
        for (WebController item : webSocketSet){
            try {
                //收到消息之后返回数据
                System.out.println("收到消息之后返回数据:"+item);
                item.sendMessage(message);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }
        }
    }

    @OnError
    public void onError(Session session , Throwable err){
        log.info("连接错误");
        err.printStackTrace();
    }
    /*
       实现服务器主动推送
        */
    public static void sendMessage(String message) {
        for (WebController webSocketServer : webSocketSet) {
            try {

                //给前端发送数据
                webSocketServer.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static  synchronized void  addOnlineCount(){
        WebController.onlineCount++;
    }

    public static synchronized int getOnlineCount(){
        return onlineCount;
    }

    public static synchronized void subOnlineCount(){
        WebController.onlineCount--;
    }




}
