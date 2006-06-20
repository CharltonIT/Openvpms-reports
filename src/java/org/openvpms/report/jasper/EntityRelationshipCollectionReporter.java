/*
 *  Version: 1.0
 *
 *  The contents of this file are subject to the OpenVPMS License Version
 *  1.0 (the 'License'); you may not use this file except in compliance with
 *  the License. You may obtain a copy of the License at
 *  http://www.openvpms.org/license/
 *
 *  Software distributed under the License is distributed on an 'AS IS' basis,
 *  WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 *  for the specific language governing rights and limitations under the
 *  License.
 *
 *  Copyright 2006 (C) OpenVPMS Ltd. All Rights Reserved.
 *
 *  $Id$
 */

package org.openvpms.report.jasper;

import org.openvpms.component.business.domain.im.archetype.descriptor.ArchetypeDescriptor;
import org.openvpms.component.business.domain.im.archetype.descriptor.NodeDescriptor;
import org.openvpms.component.business.service.archetype.IArchetypeService;

import java.util.ArrayList;
import java.util.List;


/**
 * Add description here.
 *
 * @author <a href="mailto:support@openvpms.org">OpenVPMS Team</a>
 * @version $LastChangedDate: 2006-05-02 05:16:31Z $
 */
public class EntityRelationshipCollectionReporter
        extends AbstractIMObjectCollectionReporter {

    /**
     * Construct a new <code>AbstractIMObjectCollectionReporter</code>.
     *
     * @param descriptor the collection node descriptor
     * @param service    the archetype service
     */
    public EntityRelationshipCollectionReporter(NodeDescriptor descriptor,
                                                IArchetypeService service) {
        super(descriptor, service);
    }

    /**
     * Returns the descriptors of the nodes to display.
     *
     * @return the descriptors of the nodes to display
     */
    protected List<NodeDescriptor> getDescriptors() {
        ArchetypeDescriptor archetype = getArchetype();
        NodeDescriptor target = archetype.getNodeDescriptor("target");
        List<ArchetypeDescriptor> archetypes = getArchetypes(target);
        ArchetypeDescriptor targetArch = archetypes.get(0);
        NodeDescriptor name = targetArch.getNodeDescriptor("name");
        List<NodeDescriptor> result = new ArrayList<NodeDescriptor>();
        NodeDescriptor description = archetype.getNodeDescriptor("description");
        result.add(name);
        result.add(description);
        return result;
    }

    /**
     * Returns the node name to be used in a field expression.
     *
     * @param descriptor the node descriptor
     * @return the node name
     */
    protected String getFieldName(NodeDescriptor descriptor) {
        if (descriptor.getName().equals("name")) {
            return "target.name";
        }
        return super.getFieldName(descriptor);
    }
}
