package org.reactome.server.tools.diagram.data.layout;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface SummaryItem {

    String getType();

    Shape getShape();

    Boolean getPressed();

    void setPressed(Boolean pressed);

    Integer getNumber();

    void setNumber(Integer number);

    void setHit(Boolean hit);

    Boolean getHit();
}
