
package com.dao.semapi.dto.definition;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "definition",
    "partOfSpeech"
})
@Getter
public class Definition {

    @JsonProperty("definition")
    public String definition;
    @JsonProperty("partOfSpeech")
    public String partOfSpeech;

}
