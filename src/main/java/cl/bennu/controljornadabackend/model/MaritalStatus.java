package cl.bennu.controljornadabackend.model;

import cl.bennu.commons.domain.base.BaseDomain;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MaritalStatus extends BaseDomain implements Serializable {

    private String name;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static MaritalStatus valueOf(Long id) {
        MaritalStatus o = new MaritalStatus();
        o.setId(id);

        return o;
    }
}