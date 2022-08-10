/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.mp.tech.test.model.util;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@XmlRootElement(name = "details")
public class ResultResponse {

    private List<MessageResult> details = new ArrayList();

    public ResultResponse() {
    }

    @XmlElement(name = "detail")
    public List<MessageResult> getMessages() {
        return details;
    }

    public void setMessages(List<MessageResult> messages) {
        this.details = messages;
    }

    @Override
    public String toString() {
        return "ResultResponse{ details=" + details + '}';
    }

}
