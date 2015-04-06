package com.epam.khodyka.commands;

import java.util.List;

import com.epam.khodyka.model.Model;

public abstract class Command {

	private List<String> args;

	public Command(List<String> args) {
		this.args = args;
	}

	public Command() {
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

	public abstract String execute(Model model);
}
