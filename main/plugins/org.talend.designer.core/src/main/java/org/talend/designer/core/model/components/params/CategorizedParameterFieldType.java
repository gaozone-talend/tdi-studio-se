package org.talend.designer.core.model.components.params;

import org.talend.core.model.process.EParameterFieldType;

public class CategorizedParameterFieldType extends DetailedParameterFieldType {

	private final ParameterFieldTypeCategory category;

	public CategorizedParameterFieldType(EParameterFieldType type, ParameterFieldTypeCategory category) {
		super(type);
		this.category = category;
	}

	
}
