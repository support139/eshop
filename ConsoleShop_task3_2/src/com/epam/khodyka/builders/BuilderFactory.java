package com.epam.khodyka.builders;

import com.epam.khodyka.builders.reflection.ReflectionBuilder;
import com.epam.khodyka.dataDispatcher.ConsoleDataDispatcher;
import com.epam.khodyka.dataDispatcher.DataDispatcher;
import com.epam.khodyka.dataDispatcher.RandomDataDispatcher;

public class BuilderFactory {

	private static BuilderFactory builderFactory;
	private BuildRunner runner;

	private BuilderFactory() {
	}

	public static BuilderFactory getInstance() {
		if (builderFactory == null) {
			builderFactory = new BuilderFactory();
		}
		return builderFactory;
	}

	public BuildRunner getBuilderRunner() {
		return runner;
	}

	public boolean BuildRunnerInitiator(String builderType) {
		if (runner != null) {
			return false;
		}
		runner = new BuildRunner();
		DataDispatcher dispatcher = null;
		if (builderType.equalsIgnoreCase("console")) {
			dispatcher = new ConsoleDataDispatcher();
		} else if (builderType.equalsIgnoreCase("random")) {
			dispatcher = new RandomDataDispatcher();
		}
		runner.addBuilder(new ReflectionBuilder(dispatcher));
		return true;
	}

}
