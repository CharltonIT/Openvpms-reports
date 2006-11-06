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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.openvpms.component.business.domain.im.common.IMObject;
import org.openvpms.report.IMObjectReport;

import java.util.Collection;


/**
 * Generates a jasper report for an <code>IMObject</code>.
 *
 * @author <a href="mailto:support@openvpms.org">OpenVPMS Team</a>
 * @version $LastChangedDate: 2006-05-02 05:16:31Z $
 */
public interface JasperIMObjectReport extends IMObjectReport {

    /**
     * Generates a report.
     *
     * @param objects the objects to report on
     * @return the report
     * @throws JRException for any error
     */
    JasperPrint report(Collection<IMObject> objects) throws JRException;

    /**
     * Returns the master report.
     *
     * @return the master report
     */
    JasperReport getReport();

    /**
     * Returns the sub-reports.
     *
     * @return the sub-reports.
     */
    JasperReport[] getSubreports();
}
