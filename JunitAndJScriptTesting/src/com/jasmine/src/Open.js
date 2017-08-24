/**
 * 
 */
function Open(){
}
Open.prototype.validate = function(fileName)
{
	if(fileName==null||fileName==""||fileName==" "){
		return "file name must";
    }
    else{
    	return "able to open a file";
    }	
}
Open.prototype.ajaxCall = function(fileName){
	if(fileName==null||fileName==""||fileName==" "){
		return "not possibel to call Ajax";
    }
    else{
    	return "possibel to call Ajax";
    }	
}
Open.prototype.emptyField = function(boolean){
	if(boolean)
		{
		return boolean;
		}
	else
		{
		return boolean;
		}
}