package org.reactome.server.tools.diagram.data.layout;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Kostas Sidiropoulos (ksidiro@ebi.ac.uk)
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public interface Color {

    Integer getR();

    Integer getG();

    Integer getB();

}
