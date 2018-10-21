package org.reactome.server.tools.diagram.data.layout;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Kostas Sidiropoulos (ksidiro@ebi.ac.uk)
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public interface NodeAttachment {

    String getLabel();

    String getDescription();

    Long getReactomeId();

    Shape getShape();

}
