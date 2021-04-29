package com.samsungcard.helloworld.global.error;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;

//@Component
public class SystemErrorAttributes extends DefaultErrorAttributes {
//    @Override
//    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
//        Map<String, Object> attributes = super.getErrorAttributes(webRequest, options);
//        //...message convert...
//        String message = (String) attributes.get("message");
//        attributes.put("message", message);
//        return attributes;
//    }
}
