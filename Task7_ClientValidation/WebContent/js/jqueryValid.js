formRules = {
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
	email : {
		rules : {
			required : true,
			regex : /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
		},
		messages : {
			required : "emailRequired",
			regex : "emailRegex"
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
	}
};

$("#signUpForm").submit(function() {
	var valid = true;
	for ( var tmp in formRules) {
		var rule = formRules[tmp];
		var element = $("#" + tmp);
		valid = validateLogic(rule, element);
	}
	return valid;
});

function validateLogic(rule, element) {
	var valid = true;
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
	if (!$(element).val()) {
		return show(element, messages, tmpRule);
	}
	return true;
}

function validateRegex(element, regexp, tmpRule, messages) {
	if (!regexp.test($(element).val())) {
		return show(element, messages, tmpRule);
	}
	return true;
}

function show(element, messages, tmpRule) {
	$(element).addClass("inputErrorBorder");
	$("#" + messages[tmpRule]).addClass("error");
	return false;
}

$("#signUpForm").find("input").focus(
		function() {
			$("#" + formRules[$(this).attr("id")].messages.required)
					.removeClass("error");
			$("#" + formRules[$(this).attr("id")].messages.regex).removeClass(
					"error");
			$("#" + $(this).attr("id")).removeClass("inputErrorBorder");
		});
