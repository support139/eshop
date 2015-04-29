formRules = {
	login : {
		rules : {
			required : true,
			regex : /^[a-zA-Z0-9]+$/
		},
		messges : {
			required : "loginRequired",
			regex : "loginRegex",
		}
	},
	password : {
		rules : {
			required : true,
			regex : /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,20}$/,
		},
		messages : {
			required : "passwordRequired",
			regex : "passwordRegex"
		}
	},
	name : {
		rules : {
			required : true,
			regex : /^[a-zA-Z0-9]+$/
		},
		messages : {
			required : "nameRequired",
			regex : "nameRegex"
		}
	},
	surname : {
		rules : {
			required : true,
			regex : /^[a-zA-Z0-9]+$/
		},
		messages : {
			required : "surnameRequired",
			regex : "surnameRegex"
		}
	},
	email : {
		rules : {
			required : true,
			regex : /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
		},
		messages : {
			required : "emailRequired",
			regex : "emailRegex"
		}
	}
};

document.forms["signUpForm"].onsubmit = function() {
	var valid = true;
	for ( var tmp in formRules) {
		var rule = formRules[tmp];
		var element = document.getElementById(tmp);
		valid = validateLogic(rule, element, valid);
	}
	return valid;
}

function validateLogic(rule, element, valid) {
	var rules = rule.rules;
	var messages = rule.messages;
	for ( var tmpRule in rules) {
		switch (tmpRule) {
		case "required":
			if (rules[tmpRule]) {
				valid = validateRequired(element, tmpRule, messages);
			}
			break;
		case "regex":
			var regexp = rules[tmpRule];
			valid = validateRegex(element, regexp, tmpRule, messages);
			break;
		}
		if (!valid) {
			break;
		}
	}
	return valid;
}

function validateRequired(element, tmpRule, messages) {
	if (element.value == "") {
		element.className = "inputErrorBorder";
		document.getElementById(messages[tmpRule]).className += " "
				+ element.getAttribute("id") + "ErrorSpan";
		return false;
	}
	return true;
}

function validateRegex(element, regexp, tmpRule, messages) {
	if (!regexp.test(element.value)) {
		element.className = "inputErrorBorder";
		document.getElementById(messages[tmpRule]).className += " "
				+ element.getAttribute("id") + "ErrorSpan";
		return false;
	}
	return true;
}

document.getElementById("name").onfocus = function() {
	document.getElementById("name").className = "";
	document.getElementById("nameRequired").className = 'errorSpan';
	document.getElementById("nameRegex").className = 'errorSpan';
}

document.getElementById("email").onfocus = function() {
	document.getElementById("email").className = "";
	document.getElementById("emailRequired").className = 'errorSpan';
	document.getElementById("emailRegex").className = 'errorSpan';
}

document.getElementById("password").onfocus = function() {
	document.getElementById("password").className = "";
	document.getElementById("passwordRequired").className = 'errorSpan';
	document.getElementById("passwordRegex").className = 'errorSpan';
}
