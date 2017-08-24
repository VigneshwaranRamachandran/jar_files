/**
 * 
 */
function Save(){
}
Save.prototype.validate = function(fileName)
{
	if(fileName==null||fileName==""||fileName==" "){
		return "file not be created";
    }
    else{
    	return "able to store a file";
    }	
}
Save.prototype.ajaxCall = function(fileName){
	if(fileName==null||fileName==""||fileName==" "){
		return "not possibel to call Ajax";
    }
    else{
    	return "possibel to call Ajax";
    }	
}
Save.prototype.emptyField = function(boolean){
	if(boolean)
		{
		return boolean;
		}
	else
		{
		return boolean;
		}
}
