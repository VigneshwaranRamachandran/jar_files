/**
 * 
 */
describe("For a SAVE Function ", function() {
	var server;

	beforeEach(function() {
		server = sinon.fakeServer.create();
	});

	it("should fake a jQuery ajax request", function() {
		server.respondWith("GET", "/MessageServlet", [ 200, {
			"Content-Type" : "application/json"
		}, '{ message}' ]);

		var callbacks = [ sinon.spy(), sinon.spy() ];
		server.autoRespond = true;
		jQuery.ajax({
			url : "/MessageServlet",
			success : callbacks[0]
		});

		jQuery.ajax({
			url : "/other",
			success : callbacks[1]
		});

		console.log(server.requests);
		server.respond(); 
		expect(callbacks[0].called).toBeFalsy();

		expect(callbacks[1].called).toBeFalsy(); 
	});

	it("ajax testing using FAKESERVER", function() {
		var xhr = sinon.useFakeXMLHttpRequest();
		var requests = sinon.requests = [ "/MessageServlet" ];

		xhr.onCreate = function(request) {
			requests.push(request);
		};

		var callback = sinon.spy();

		$.ajax('/MessageServlet', {
			success : callback
		});
		expect(sinon.requests[0]).toEqual("/MessageServlet");
		expect(sinon.requests.length).toEqual(1);
	});
	it("test should fake SUCCESSFULL Ajax request", function() {
		sinon.stub(jQuery, "ajax").yieldsTo("success", [ 'MessageServlet' ]);

		jQuery.ajax({

			url : "/MessageServlet",
			success : function(url) {
				expect([ "MessageServlet", url ]);
				alert("received data is : " + url);
			}
		});

	})

});

 describe("For a SEARCH Function ", function() {
 	var server;

 	beforeEach(function() {
 		server = sinon.fakeServer.create();
 	});

 	it("should fake a jQuery ajax request", function() {
 		server.respondWith("GET", "/SearchServlet", [ 200, {
 			"Content-Type" : "application/json"
 		}, '{ message}' ]);

 		var callbacks = [ sinon.spy(), sinon.spy() ];
 		server.autoRespond = true;
 		jQuery.ajax({
 			url : "/SearchServlet",
 			success : callbacks[0]
 		});

 		jQuery.ajax({
 			url : "/other",
 			success : callbacks[1]
 		});

 		console.log(server.requests);
 		server.respond(); 
 		expect(callbacks[0].called).toBeTruthy();

 		expect(callbacks[1].called).toBeTruthy(); 
 	});


 	
 	it("ajax testing using FAKESERVER", function() {
 		var xhr = sinon.useFakeXMLHttpRequest();
 		var requests = sinon.requests = [ "/SearchServlet" ];

 		xhr.onCreate = function(request) {
 			requests.push(request);
 		};

 		var callback = sinon.spy();

 		$.ajax('/SearchServlet', {
 			success : callback
 		});
 		expect(sinon.requests[0]).toEqual("/SearchServlet");
 		expect(sinon.requests.length).toEqual(1);
 	});

 });
 describe("For a DELETE Function ", function() {
	 	var server;

	 	beforeEach(function() {
	 		server = sinon.fakeServer.create();
	 	});

	 	it("should fake a jQuery ajax request", function() {
	 		server.respondWith("GET", "/DeleteData", [ 200, {
	 			"Content-Type" : "application/json"
	 		}, '{ message}' ]);

	 		var callbacks = [ sinon.spy(), sinon.spy() ];
	 		server.autoRespond = true;
	 		jQuery.ajax({
	 			url : "/DeleteData",
	 			success : callbacks[0]
	 		});

	 		jQuery.ajax({
	 			url : "/other",
	 			success : callbacks[1]
	 		});

	 		console.log(server.requests);
	 		server.respond(); 
	 		expect(callbacks[0].called).toBeTruthy();

	 		expect(callbacks[1].called).toBeTruthy(); 
	 	});

	 	it("ajax testing using FAKESERVER", function() {
	 		var xhr = sinon.useFakeXMLHttpRequest();
	 		var requests = sinon.requests = [ "/DeleteData" ];

	 		xhr.onCreate = function(request) {
	 			requests.push(request);
	 		};

	 		var callback = sinon.stub();

	 		$.ajax('/DeleteData', {
	 			success : callback
	 		});
	 		expect(sinon.requests[0]).toEqual("/DeleteData");
	 		expect(sinon.requests.length).toEqual(1);
	 	});
	 	
	 });
 describe("For a UPDATE Function ", function() {
	 	var server;

	 	beforeEach(function() {
	 		server = sinon.fakeServer.create();
	 	});

	 	it("should fake a jQuery ajax request", function() {
	 		server.respondWith("GET", "/UpdateData", [ 200, {
	 			"Content-Type" : "application/json"
	 		}, '{ message}' ]);

	 		var callbacks = [ sinon.spy(), sinon.spy() ];
	 		server.autoRespond = true;
	 		jQuery.ajax({
	 			url : "/UpdateData",
	 			success : callbacks[0]
	 		});

	 		jQuery.ajax({
	 			url : "/other",
	 			success : callbacks[1]
	 		});

	 		console.log(server.requests);
	 		server.respond(); 
	 		expect(callbacks[0].called).toBeTruthy();

	 		expect(callbacks[1].called).toBeTruthy(); 
	 	});

	 	it("ajax testing using FAKESERVER", function() {
	 		var xhr = sinon.useFakeXMLHttpRequest();
	 		var requests = sinon.requests = [ "/UpdateData" ];

	 		xhr.onCreate = function(request) {
	 			requests.push(request);
	 		};

	 		var callback = sinon.stub();

	 		$.ajax('/UpdateData', {
	 			success : callback
	 		});
	 		expect(sinon.requests[0]).toEqual("/UpdateData");
	 		expect(sinon.requests.length).toEqual(1);
	 	});
	 	
	 });