
package com.dao.semapi.dto.frequency;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "zipf",
    "perMillion",
    "diversity"
})
public class Frequency implements Serializable
{

    @JsonProperty("zipf")
    public double zipf;
    @JsonProperty("perMillion")
    public double perMillion;
    @JsonProperty("diversity")
    public double diversity;
    private final static long serialVersionUID = -8107541155684297776L;

}
