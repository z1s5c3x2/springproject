package ezenweb.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChattingController extends TextWebSocketHandler {
    // 서버소켓과 연동된 클라이언트 소켓을 저장하는 리스트
    private static List<WebSocketSession> socketSessionList = new ArrayList<>();
    //연동 성공
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        socketSessionList.add(session);
        System.out.println("session = " + session);
    }

    //오류 발생
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("session = " + session + ", exception = " + exception);
    }

    //클라이언트 소켓과 연동 끊겼을때
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        socketSessionList.remove(session);
        System.out.println("session = " + session + ", status = " + status);
    }

    //클라이언트 소켓으로부터 메세지를 받았을때

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //서버가 클라이언트로부터 받은 메세지를 서버에 모든 세션에 전달
        for (WebSocketSession _session : socketSessionList)
        {
            _session.sendMessage(message);
        }
        System.out.println("session = " + session + ", message = " + message);
    }
}
