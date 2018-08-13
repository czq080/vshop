package com.vigoss.wechat.official.mvc.controller;

import com.vigoss.wechat.core.dispatcher.MessageDispatcher;
import com.vigoss.wechat.core.request.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author chenzhiqiang
 * @date 2018/7/9
 */
@RestController
@RequestMapping("/wechat/official/message")
public class MessageController {

    @Autowired
    private MessageDispatcher messageDispatcher;

    @RequestMapping(value = "handle", method = RequestMethod.GET)
    public String handleGet(MessageRequest messageRequest, HttpServletRequest request) throws Exception {
        String xml = "";
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    request.getInputStream(), "UTF-8"));
            String line = in.readLine();
            while (line != null) {
                xml += line;
                line = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            if (in != null) {
                in.close();
            }
        }
        System.out.println(xml);
        messageRequest.setMsgSignature(request.getParameter("msg_signature"));
        return messageDispatcher.handleGet(messageRequest);
    }

    @RequestMapping(value = "handle", method = RequestMethod.POST)
    public String handlePost(MessageRequest messageRequest, HttpServletRequest request) throws Exception {
        String xml = "";
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    request.getInputStream(), "UTF-8"));
            String line = in.readLine();
            while (line != null) {
                xml += line;
                line = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            if (in != null) {
                in.close();
            }
        }
        messageRequest.setMsgSignature(request.getParameter("msg_signature"));
        return messageDispatcher.handlePost(messageRequest, xml);
    }
}
