package com.example.manageruniversity.dto.sendMail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {
        private String recipient;
        private String subject;
        private String msgBody;
        public void setMsgBody(String username, String codeForget, String urlChangePassword) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h2>Username: " + username+ "</h2>");
        stringBuilder.append("<h2>Link lấy mật khẩu: <a href = '" + urlChangePassword+ "?code="+ codeForget +  "'>Click</a></h2>");
        this.msgBody = stringBuilder.toString();
    }
}
