package com.myhotel.notificationms.entity;

import lombok.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {

    private String email;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

}
