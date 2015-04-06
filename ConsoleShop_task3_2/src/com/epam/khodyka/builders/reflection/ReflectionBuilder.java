package com.epam.khodyka.builders.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ResourceBundle;

import com.epam.khodyka.builders.MusicalInstrumentBuilder;
import com.epam.khodyka.builders.anno.Setter;
import com.epam.khodyka.builders.reflection.exception.InstrumentCreatorException;
import com.epam.khodyka.dataDispatcher.DataDispatcher;
import com.epam.khodyka.db.entity.MusicalInstrument;
import com.epam.khodyka.service.ResourceBundleService;

public class ReflectionBuilder extends MusicalInstrumentBuilder {

	private static final String ENTITY_FULL_PATH = "com.epam.khodyka.db.entity.";
	private ResourceBundle bundle = ResourceBundleService.getBundle();

	public ReflectionBuilder(DataDispatcher dispatcher) {
		super(dispatcher);
	}

	@Override
	public MusicalInstrument create(String productName)
			throws InstrumentCreatorException {
		try {
			MusicalInstrument instrument = (MusicalInstrument) Class.forName(
					getFullClassName(productName)).newInstance();
			Class<?> clazz = instrument.getClass();
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				if (m.isAnnotationPresent(Setter.class)) {
					filler(m, instrument);
				}
			}
			return instrument;
		} catch (Exception e) {
			throw new InstrumentCreatorException();
		}
	}

	public String getFullClassName(String simpleClassName) {
		return ENTITY_FULL_PATH + simpleClassName;
	}

	public void filler(Method m, MusicalInstrument instrument)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		String message = (String) bundle.getObject(m
				.getAnnotation(Setter.class).name());
		if (getSetterParamType(m) == int.class) {
			m.invoke(instrument, dispatcher.getIntData(message));
		} else if (getSetterParamType(m) == long.class) {
			m.invoke(instrument, dispatcher.getLongData(message));
		} else if (getSetterParamType(m) == double.class) {
			m.invoke(instrument, dispatcher.getDoubleData(message));
		} else if (getSetterParamType(m) == String.class) {
			m.invoke(instrument, dispatcher.getStringData(message));
		}
	}

	public Class<?> getSetterParamType(Method m) {
		return m.getParameterTypes()[0];
	}

	@Override
	public MusicalInstrument getInstrument() {
		return null;
	}

}
