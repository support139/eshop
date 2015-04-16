package com.epam.khodyka.builders;

import com.epam.khodyka.builders.reflection.ReflectionBuilder;
import com.epam.khodyka.datadispatcher.ConsoleDataDispatcher;
import com.epam.khodyka.datadispatcher.DataDispatcher;
import com.epam.khodyka.datadispatcher.RandomDataDispatcher;

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
