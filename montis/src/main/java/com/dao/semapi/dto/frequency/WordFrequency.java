
package com.dao.semapi.dto.frequency;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "word",
    "frequency"
})
public class WordFrequency implements Serializable
{

    @JsonProperty("word")
    public String word;
    @JsonProperty("frequency")
    public Frequency frequency;
    private final static long serialVersionUID = 3702799218976351378L;

}
