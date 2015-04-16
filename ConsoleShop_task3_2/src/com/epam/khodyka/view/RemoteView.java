package com.epam.khodyka.view;

import java.io.DataOutputStream;

import com.epam.khodyka.model.Model;

public interface RemoteView {
	void show(Model model, DataOutputStream dataOutputStream);
}
