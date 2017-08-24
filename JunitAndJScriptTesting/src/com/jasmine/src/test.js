/**
 * 
 */


	it("should able to call release function with stub", function () {
	var stub = sinon.stub();
	stub.withArgs(10).returns(1);
	stub.withArgs(20).returns(0);
	circles.release(stub,10);
	sinon.assert.called(stub);

	});



	it("test should assert json object",function () {
	var details = {
	name : "nan",
	job : "developer",
	company : "full",
	email : "nan@gamil.com",
	worknum : 23456787,
	mobnum : 9876543210,
	address : "asdfghjkl"

	};
	var spy = sinon.spy();

	spy(details);
	// sinon.assert.calledWith(spy, sinon.match({ mobnum : 987654321 }));
	sinon.assert.calledWith(spy, sinon.match({ mobnum : 9876543210 }));
	sinon.assert.calledWith(spy, sinon.match({ name : "nan" }));
	sinon.assert.calledWith(spy, sinon.match({ address : "asdfghjkl" }));
	});

	function getTodos(listId, callback) {
	ajax({
	url: "/todo/" + listId + "/items",
	success: function (data) {
	// Node-style CPS: callback(err, data)
	// callback(data);
	}
	});
	}

	describe('myFunction', function() {
	afterEach(function () {
	// When the test either fails or passes, restore the original
	// jQuery ajax function (Sinon.JS also provides tools to help
	// test frameworks automate clean-up like this)
	ajax.restore();
	});

	it("makes a GET request for todo items", function () {
	sinon.stub("ajax");

	getTodos(42, sinon.spy());

	assert(jQuery.ajax.calledWithMatch({ url: "/todo/42/items" }));
	});

	});

	




//Circles.prototype.saveUser=function(user, callback) {
//	$.post('/users', {
//	first: user.firstname,
//	last: user.lastname
//	}, callback);
//	}
//Circles.prototype.fetch = function(circles) {
//for(i in circles) {
// circle.draw();
// }
//};