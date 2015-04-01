package com.epam.khodyka.commands.factories;

import java.util.List;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.commands.implementation.ShowHelpCommand;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class ShowHelpCommandFactory implements AbstractFactory {

	@Override
	public Command getCommand(List<String> args) {
		return new ShowHelpCommand();
	}
}
