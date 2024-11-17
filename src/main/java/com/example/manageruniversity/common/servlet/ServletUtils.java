package com.example.manageruniversity.common.servlet;

import com.example.manageruniversity.common.json.JsonUtils;
import com.example.manageruniversity.common.pojo.CommonResult;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;

public class ServletUtils {


    public static void writeJson(HttpServletResponse response, CommonResult<?> object) {
        String content = JsonUtils.write(object);
        write(response,object.getCode(), content, MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

    private static void write(HttpServletResponse response, int code,  String content, String contentType) {
        response.setContentType(contentType);
        response.setStatus(code);
        try {
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
