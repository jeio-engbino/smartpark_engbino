package org.smartparking.vo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseVo {

    public static ResponseEntity<Object> success(List<?> responseDataList) {
        return buildSuccessResponseEntity(responseDataList);
    }

    public static ResponseEntity<Object> success() {
        return buildSuccessResponseEntity(null);
    }

    private static ResponseEntity<Object> buildSuccessResponseEntity(Object responseData) {
        return getObjectResponseEntity("Operation Success", HttpStatus.OK, responseData);
    }

    public static ResponseEntity<Object> fail(String errorMessage) {
        return getObjectResponseEntity(errorMessage, HttpStatus.BAD_REQUEST, null);
    }

    private static ResponseEntity<Object> getObjectResponseEntity(String message, HttpStatus status, Object responseData) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseData);
        return new ResponseEntity<>(map, status);
    }

}
