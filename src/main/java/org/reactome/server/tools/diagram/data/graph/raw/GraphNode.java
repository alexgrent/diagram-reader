package org.reactome.server.tools.diagram.data.graph.raw;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface GraphNode {

    Long getDbId();

    String getStId();

    String getDisplayName();

    String getSchemaClass();

    Long getSpeciesID();

}
