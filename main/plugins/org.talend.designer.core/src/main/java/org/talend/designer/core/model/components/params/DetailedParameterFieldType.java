package org.talend.designer.core.model.components.params;

import java.util.ResourceBundle;

import org.talend.core.model.process.EParameterFieldType;
import org.talend.core.model.process.INode;
import org.talend.designer.core.i18n.Messages;
import org.talend.designer.core.model.components.ElementParameter;
import org.talend.designer.core.model.utils.emf.component.PARAMETERType;

public class DetailedParameterFieldType {

    public static final String PROP_NAME = "NAME"; //$NON-NLS-1$
    
    public final EParameterFieldType type;

    public DetailedParameterFieldType(EParameterFieldType type) {
        this.type = type;
    }

    public ElementParameter createParameterForNode(final INode node,PARAMETERType xmlParam, boolean advanced) {
        ElementParameter param = new ElementParameter(node);
        param.setName(xmlParam.getNAME());
        param.setDisplayName(getTranslatedValue(xmlParam.getNAME() + "." + PROP_NAME)); //$NON-NLS-1$
        if (xmlParam.getGROUP() != null) {
            param.setGroupDisplayName(getTranslatedValue(xmlParam.getGROUP() + "." + PROP_NAME));//$NON-NLS-1$
        }
        param.setFieldType(type);
        param.setNumRow(xmlParam.getNUMROW());
        if (xmlParam.isSetREADONLY()) {
            param.setReadOnly(xmlParam.isREADONLY());
        }
        if (xmlParam.isSetREQUIRED()) {
            param.setRequired(xmlParam.isREQUIRED());
        }
        if (xmlParam.isSetSHOW()) {
            param.setShow(xmlParam.isSHOW());
        }
        if (xmlParam.isSetNBLINES()) {
            param.setNbLines(xmlParam.getNBLINES());
        }
        if (xmlParam.isSetDYNAMICSETTINGS()) {
            param.setDynamicSettings(xmlParam.isDYNAMICSETTINGS());
        }

        param.setFilter(xmlParam.getFILTER());
        param.setShowIf(xmlParam.getSHOWIF());
        param.setRequiredIF(xmlParam.getREQUIREDIF());
        param.setNotShowIf(xmlParam.getNOTSHOWIF());
        param.setReadOnlyIf(xmlParam.getREADONLYIF());
        param.setNotReadOnlyIf(xmlParam.getNOTREADONLYIF());
        if (xmlParam.getREPOSITORYVALUE() != null) {
            if (xmlParam.getREPOSITORYVALUE().contains("/")) { //$NON-NLS-1$
                String values[] = xmlParam.getREPOSITORYVALUE().split("/"); //$NON-NLS-1$
                param.setRepositoryProperty(values[0]);
                param.setRepositoryValue(values[1]);
            } else {
                param.setRepositoryValue(xmlParam.getREPOSITORYVALUE());
            }
        }
        param.setGroup(xmlParam.getGROUP());
        param.setContext(xmlParam.getCONTEXT());
        param.setBackgroundColor(getColor(param, xmlParam.getBACKGROUND()));
        param.setColor(getColor(param, xmlParam.getCOLOR()));
        param.setContextMode(xmlParam.isCONTEXTMODE());
        param.setNoContextAssist(xmlParam.isNOCONTEXTASSIST());
        if (xmlParam.isSetMAXLENGTH()) {
            param.setMaxLength(xmlParam.getMAXLENGTH());
        }
        return param;
    }

    private String getTranslatedValue(final INode node, String nameValue) {
        String returnValue = nameValue;
        if (translatedMap.containsKey(nameValue)) {
            return translatedMap.get(nameValue);
        }
        // modified by wzhang. update translations for components.
        returnValue = Messages.getString(nameValue, node.getComponent().getName(), getResourceBundle(node));
        translatedMap.put(nameValue, returnValue);
        return returnValue;
    }

    private ResourceBundle getResourceBundle(INode node) {
        node.getComponent().get
        return null;
    }
}
