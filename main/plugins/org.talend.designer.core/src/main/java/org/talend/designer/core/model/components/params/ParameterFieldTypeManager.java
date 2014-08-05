package org.talend.designer.core.model.components.params;

import java.util.concurrent.ExecutionException;

import org.talend.commons.exception.ExceptionHandler;
import org.talend.core.model.process.EParameterFieldType;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class ParameterFieldTypeManager {

	static final LoadingCache<EParameterFieldType, DetailedParameterFieldType> CACHE;
	static {
		CACHE = CacheBuilder.newBuilder().build(new CacheLoader<EParameterFieldType, DetailedParameterFieldType>() {

			@Override
			public DetailedParameterFieldType load(final EParameterFieldType paramK) throws Exception {
				return ParameterFieldTypeManager.load(paramK);
			}
		});
	}

	public static DetailedParameterFieldType getDetailed(EParameterFieldType type) {
		try {
			return CACHE.get(type);
		} catch (ExecutionException e) {
			ExceptionHandler.process(e);
			return null;
		}
	}

	protected static DetailedParameterFieldType load(EParameterFieldType type) {
		
		return null;
	}
}
