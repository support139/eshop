package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.Command;

/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public interface AbstractFactory {

	Command getCommand(List<String> args);
}
