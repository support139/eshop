package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.implementation.CreateProductBuilderCommand;

public class CreateProductBuilderCommandFactory implements AbstractFactory {

	@Override
	public Command getCommand(List<String> args) {
		return new CreateProductBuilderCommand(args.get(0));
	}
}
