/**
 * 
 */
describe("Signup Page", function() {

	var signup;
	beforeEach(function() {

		signup = new Signup();
	});

	it('should able to call signup function,check using spy', function() {
		var signUp = sinon.spy();

		signup.functionCall(true, signUp);
		sinon.assert.called(signUp);
		expect(signup.functionCall(true, signUp)).toEqual(1);
		expect(signup.functionCall(false, signUp)).toEqual(0);
	});
	it("should be able to signup", function() {
		expect(1).toBe(1);
		expect(signup.validate(null, null)).toEqual("Invalid");
		expect(signup.validate("", null)).toEqual("Invalid");
		expect(signup.validate(null, "")).toEqual("Invalid");
		expect(signup.validate("", "")).toEqual("Invalid");
		expect(signup.validate("m", null)).toEqual("Invalid");
		expect(signup.validate(null, "g")).toEqual("Invalid");
		expect(signup.validate("j", "j")).toEqual("valid input");
		expect(signup.validate(" ", " ")).toEqual("valid input");
		expect(signup.validate(" ", null)).toEqual("Invalid");
		expect(signup.validate(null, " ")).toEqual("Invalid");
	});
	it('should able to call a function with parameter value,check using spy',
			function() {
				var signUp = sinon.spy();
				signup.functionCall(true, signUp);
				sinon.assert.calledWith(signUp, "vicky1", "vicky1");
			});
	it("should able to call a function,check using stub", function() {
		var signUp = sinon.stub();
		signup.functionCall(true, signUp);
		sinon.assert.called(signUp);
		expect(signup.functionCall(true, signUp)).toEqual(1);
		expect(signup.functionCall(false, signUp)).toEqual(0);
	});
	it("should able to call a function with parameter value,check using stub",
			function() {
				var signUp = sinon.stub();
				signUp.withArgs(10).returns(1);
				signUp.withArgs(20).returns(0);
				signup.functionCall(true, signUp);
				sinon.assert.called(signUp);

			});
});
describe("Login Page", function() {
	var login;
	beforeEach(function() {
		login = new Loginv();
	});

	it("should be able to login", function() {
		expect(login.validate(null, null)).toEqual("Invalid");
		expect(login.validate("", null)).toEqual("Invalid");
		expect(login.validate(null, "")).toEqual("Invalid");
		expect(login.validate("", "")).toEqual("Invalid");
		expect(login.validate("m", null)).toEqual("Invalid");
		expect(login.validate(null, "g")).toEqual("Invalid");
		expect(login.validate("j", "j")).toEqual("valid input");
		expect(login.validate(" ", " ")).toEqual("valid input");
		expect(login.validate(" ", null)).toEqual("Invalid");
		expect(login.validate(null, " ")).toEqual("Invalid");
	});
	it('should able to call login function,check using spy', function() {
		var logIn = sinon.spy();

		login.functionCall(true, logIn);
		sinon.assert.called(logIn);
		expect(login.functionCall(true, logIn)).toEqual(1);
		expect(login.functionCall(false, logIn)).toEqual(0);
	});
	it('should able to call a function with parameter value,check using spy',
			function() {
				var logIn = sinon.spy();
				login.functionCall(true, logIn);
				sinon.assert.calledWith(logIn, "vicky1", "vicky1");
			});
	it("should able to call a function,check using stub", function() {
		var logIn = sinon.stub();
		login.functionCall(true, logIn);
		sinon.assert.called(logIn);
		expect(login.functionCall(true, logIn)).toEqual(1);
		expect(login.functionCall(false, logIn)).toEqual(0);
	});
	it("should able to call a function with parameter value,check using stub",
			function() {
				var logIn = sinon.stub();
				logIn.withArgs(10).returns(1);
				logIn.withArgs(20).returns(0);
				login.functionCall(true, logIn);
				sinon.assert.called(logIn);

			});
});
describe("Home Page 'SAVE' Function", function() {
	var savee = "MessageServlet";
	var save;
	beforeEach(function() {
		save = new Save();
	})
	it("should be able to 'Save'", function() {
		expect(save.validate(null)).toEqual("file not be created");
		expect(save.validate("")).toEqual("file not be created");
		expect(save.validate(" ")).toEqual("file not be created");
		expect(save.validate("ff")).toEqual("able to store a file");

	});
	it("should be able to call 'AJAX Function'", function() {
		expect(save.ajaxCall(null)).toEqual("not possibel to call Ajax");
		expect(save.ajaxCall("")).toEqual("not possibel to call Ajax");
		expect(save.ajaxCall(" ")).toEqual("not possibel to call Ajax");
		expect(save.ajaxCall("ff")).toEqual("possibel to call Ajax");

	});
	it("after Ajax call,that field will be empty", function() {
		expect(save.emptyField(true)).toBeTruthy();
		expect(save.emptyField(false)).toBeFalsy();
	});

});

describe("Home Page 'SEARCHING' Function", function() {
	var searching = "SearchServlet";
	var search;
	beforeEach(function() {
		search = new Search();
	})
	it("should be able to 'Search' a file", function() {
		expect(search.validate(null)).toEqual("file name must");
		expect(search.validate("")).toEqual("file name must");
		expect(search.validate(" ")).toEqual("file name must");
		expect(search.validate("ff")).toEqual("able to search a file");

	});
	it("should be able to call 'AJAX' Function", function() {
		expect(search.ajaxCall(null)).toEqual("not possibel to call Ajax");
		expect(search.ajaxCall("")).toEqual("not possibel to call Ajax");
		expect(search.ajaxCall(" ")).toEqual("not possibel to call Ajax");
		expect(search.ajaxCall("ff")).toEqual("possibel to call Ajax");

	});
	it("after Ajax call,that field will be empty", function() {
		expect(search.emptyField(true)).toBeTruthy();
		expect(search.emptyField(false)).toBeFalsy();
	});
	it("test should fake SUCCESSFULL Ajax request", function() {
 		sinon.stub(jQuery, "ajax").yieldsTo("success", ['SearchServlet' ]);

 		jQuery.ajax({

 			url : "/SearchServlet",
 			success : function(url) {
 				expect([ "SearchServlet", url]);
 					}
 		});

 	})

});

describe("Home Page 'DELETEING' Function", function() {
	var deleing = "DeleteData";
	var deleteing;
	beforeEach(function() {
		deleteing = new Delete();
	})
	it("should be able to 'Deleteing' a file", function() {
		expect(deleteing.validate(null)).toEqual("file name must");
		expect(deleteing.validate("")).toEqual("file name must");
		expect(deleteing.validate(" ")).toEqual("file name must");
		expect(deleteing.validate("ff")).toEqual("able to deleteing a file");

	});
	it("should be able to call 'AJAX' Function", function() {
		expect(deleteing.ajaxCall(null)).toEqual("not possibel to call Ajax");
		expect(deleteing.ajaxCall("")).toEqual("not possibel to call Ajax");
		expect(deleteing.ajaxCall(" ")).toEqual("not possibel to call Ajax");
		expect(deleteing.ajaxCall("ff")).toEqual("possibel to call Ajax");

	});
	it("after Ajax call,that field will be empty", function() {
		expect(deleteing.emptyField(true)).toBeTruthy();
		expect(deleteing.emptyField(false)).toBeFalsy();
	});
	

});
describe("Home Page 'EDITING' Function", function() {
	var editing = "EditData";
	var edit;
	beforeEach(function() {
		edit = new Edit();
	})
	it("should be able to 'Editing' a file", function() {
		expect(edit.validate(null)).toEqual("file name must");
		expect(edit.validate("")).toEqual("file name must");
		expect(edit.validate(" ")).toEqual("file name must");
		expect(edit.validate("ff")).toEqual("able to editing a file");

	});
	it("should be able to call 'AJAX' Function", function() {
		expect(edit.ajaxCall(null)).toEqual("not possibel to call Ajax");
		expect(edit.ajaxCall("")).toEqual("not possibel to call Ajax");
		expect(edit.ajaxCall(" ")).toEqual("not possibel to call Ajax");
		expect(edit.ajaxCall("ff")).toEqual("possibel to call Ajax");

	});
	it("after Ajax call,that field will be empty", function() {
		expect(edit.emptyField(true)).toBeTruthy();
		expect(edit.emptyField(false)).toBeFalsy();
	});

});

describe("Home Page 'UPDATE' Function", function() {
	var updating = "UpdateData";
	var update;
	beforeEach(function() {
		update = new Update();
	})
	it("should be able to 'Update' a file", function() {
		expect(update.validate(null)).toEqual("file name must");
		expect(update.validate("")).toEqual("file name must");
		expect(update.validate(" ")).toEqual("file name must");
		expect(update.validate("ff")).toEqual("able to update a file");

	});
	it("should be able to call 'AJAX' Function", function() {
		expect(update.ajaxCall(null)).toEqual("not possibel to call Ajax");
		expect(update.ajaxCall("")).toEqual("not possibel to call Ajax");
		expect(update.ajaxCall(" ")).toEqual("not possibel to call Ajax");
		expect(update.ajaxCall("ff")).toEqual("possibel to call Ajax");

	});
	it("after Ajax call,that field will be empty", function() {
		expect(update.emptyField(true)).toBeTruthy();
		expect(update.emptyField(false)).toBeFalsy();
	});

});


describe("Home Page 'OPEN' Function", function() {

	var open;
	beforeEach(function() {
		open = new Open();
	})
	it("should be able to 'Open' a file", function() {
		expect(open.validate(null)).toEqual("file name must");
		expect(open.validate("")).toEqual("file name must");
		expect(open.validate(" ")).toEqual("file name must");
		expect(open.validate("ff")).toEqual("able to open a file");

	});
	it("should be able to call 'AJAX' Function", function() {
		expect(open.ajaxCall(null)).toEqual("not possibel to call Ajax");
		expect(open.ajaxCall("")).toEqual("not possibel to call Ajax");
		expect(open.ajaxCall(" ")).toEqual("not possibel to call Ajax");
		expect(open.ajaxCall("ff")).toEqual("possibel to call Ajax");

	});
	it("after Ajax call,that field will be empty", function() {
		expect(open.emptyField(true)).toBeTruthy();
		expect(open.emptyField(false)).toBeFalsy();
	});

});
function getTodos(listId, callback) {
	$.ajax({
		url : "/todo/" + listId + "/items",
		success : function() {

			callback();
		}
	});
}

describe('testing ajax call', function() {
	afterEach(function() {
		$.ajax.restore();
	});

	it("makes a GET request for todo items", function() {
		//sinon.stub($, "ajax");
		var spy = sinon.spy();
		getTodos(42, spy);
		expect(spy.calledOnce).toBeTruthy();
	});

});
