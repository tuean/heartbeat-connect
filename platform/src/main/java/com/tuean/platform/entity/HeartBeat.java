package com.tuean.platform.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HeartBeat {

    @JsonProperty("app_version")
    private String appVersion;
    @JsonProperty("cid")
    private String cid;
    @JsonProperty("seq")
    private long seq;
    @JsonProperty("uptime")
    private long uptime;
    @JsonProperty("type")
    private long type;


}
