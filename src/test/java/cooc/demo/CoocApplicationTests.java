package cooc.demo;

import cooc.demo.websocket.WebSocketServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoocApplicationTests {

    @Test
    public void contextLoads() {
    }

    @RequestMapping(value = "/pushVideoListToWeb" , method = RequestMethod.POST, consumes = "application/json" )
    public @ResponseBody
    Map<String, Object> pushVideoListToWeb(@RequestBody Map<String, Object> param) {
        Map<String, Object> result = new HashMap<String, Object>();

        try {
            WebSocketServer.sendInfo("有新客户呼入,sltAccountId:0000000" );
            result.put("operationResult" , true);
        } catch (IOException e) {
            result.put("operationResult" , true);
        }
        return result;
    }


}
