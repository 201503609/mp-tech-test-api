/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.mp.tech.test.model.util;

/**
 *
 * @author diego
 */
public class MessageResult {

    private String statusCode = null;
    private String message = null;

    public MessageResult() {
    }

    public MessageResult(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "Message{ statusCode=" + statusCode + ", message=" + message + '}';
    }

}
