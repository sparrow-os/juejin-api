package com.sparrow.tag.protocol.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("话题")
public class TopicVO {
    public TopicVO(Long id, String topic) {
        this.id = id;
        this.topic = topic;
    }

    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("话题")
    private String topic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
