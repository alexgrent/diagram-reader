package org.reactome.server.tools.diagram.data.layout.factory;


import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.google.web.bindery.autobean.vm.AutoBeanFactorySource;
import org.reactome.server.tools.diagram.data.exception.DeserializationException;
import org.reactome.server.tools.diagram.data.layout.*;
import org.reactome.server.tools.diagram.data.layout.category.DiagramObjectCategory;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public abstract class DiagramObjectsFactory {

    @SuppressWarnings("UnusedDeclaration")
    @AutoBeanFactory.Category(DiagramObjectCategory.class)
    interface ModelAutoBeanFactory extends AutoBeanFactory {
        AutoBean<Coordinate> position();
        AutoBean<Color> colorRGB();
        AutoBean<SummaryItem> summaryItem();
        AutoBean<NodeAttachment> nodeAttachment();
        AutoBean<Identifier> mainId();

        AutoBean<DiagramObject> object();
        AutoBean<NodeProperties> prop();
        AutoBean<NodeCommon> nodeCommon();
        AutoBean<Node> node();
        AutoBean<Note> note();
        AutoBean<Compartment> compartment();
        AutoBean<Shadow> shadow();

        AutoBean<ReactionPart> reactionPart();
        AutoBean<Shape> shape();
        AutoBean<Segment> segment();
        AutoBean<Connector> connector();

        AutoBean<EdgeCommon> edgeCommon();
        AutoBean<Edge> edge();
        AutoBean<Link> link();

        AutoBean<Diagram> diagram();
    }

    public static <T> T getObject(Class<T> cls, String json) throws DeserializationException {
        try{
            AutoBeanFactory factory = AutoBeanFactorySource.create(ModelAutoBeanFactory.class);
            AutoBean<T> bean = AutoBeanCodex.decode(factory, cls, json);
            return bean.as();
        }catch (Throwable e){
            throw new DeserializationException("Error mapping json string for [" + cls + "]", e);
        }
    }
}
