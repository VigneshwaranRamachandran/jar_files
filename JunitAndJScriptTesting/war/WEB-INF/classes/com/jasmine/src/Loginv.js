/**
 * 
 */
function Loginv() {}
Loginv.prototype.validate = function(name,password) {
	if(name==null || name=="" || password==null || password=="")
		{
		return "Invalid";
		}
	else{
		return "valid input";
	}
}
Loginv.prototype.functionCall=function(boolean,signup){
	if(boolean){
		signup("vicky1","vicky1");

		return 1;

		}
		return 0;
}
