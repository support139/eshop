package com.epam.khodyka.commands.implementation;

import com.epam.khodyka.commands.Command;
import com.epam.khodyka.model.Model;
import com.epam.khodyka.view.ViewName;
/**
 * /* Copy with no changes from {ConsoleShop} /
 * 
 * @author Andrii_Khodyka
 *
 */
public class NoCommand extends Command {

	@Override
	public String execute(Model model) {
		return ViewName.WRONG_COMMAND_VIEW;
	}

}
