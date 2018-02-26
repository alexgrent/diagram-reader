package org.reactome.server.tools.diagram.data.profile.diagram;

import java.io.Serializable;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 * @author Kostas Sidiropoulos <ksidiro@ebi.ac.uk>
 */
public interface DiagramProfile extends Serializable {

    String getName();

    DiagramProfileProperties getProperties();

    DiagramProfileNode getAttachment();

    DiagramProfileNode getChemical();

    DiagramProfileNode getCompartment();

    DiagramProfileNode getComplex();

    @Deprecated
    DiagramProfileNode getEntity();

    DiagramProfileNode getEntityset();

    DiagramProfileNode getFlowline();

    DiagramProfileNode getGene();

    DiagramProfileNode getNote();

    DiagramProfileNode getInteractor();

    DiagramProfileNode getLink();

    DiagramProfileNode getOtherentity();

    DiagramProfileNode getProcessnode();

    DiagramProfileNode getEncapsulatednode();

    DiagramProfileNode getProtein();

    DiagramProfileNode getReaction();

    DiagramProfileNode getRna();

    DiagramProfileNode getStoichiometry();

    DiagramProfileThumbnail getThumbnail();

}
