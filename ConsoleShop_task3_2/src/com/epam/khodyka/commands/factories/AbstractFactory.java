package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.Command;

public interface AbstractFactory {

	Command getCommand(List<String> args);
}
