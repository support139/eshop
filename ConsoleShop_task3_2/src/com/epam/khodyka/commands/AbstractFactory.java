package com.epam.khodyka.commands;

import java.util.List;

public interface AbstractFactory {

	Command getCommand(List<String> args);
}
