/**
 * 
 */
function Search(){
}
Search.prototype.validate = function(fileName)
{
	if(fileName==null||fileName==""||fileName==" "){
		return "file name must";
    }
    else{
    	return "able to search a file";
    }	
}
Search.prototype.ajaxCall = function(fileName){
	if(fileName==null||fileName==""||fileName==" "){
		return "not possibel to call Ajax";
    }
    else{
    	return "possibel to call Ajax";
    }	
}
Search.prototype.emptyField = function(boolean){
	if(boolean)
		{
		return boolean;
		}
	else
		{
		return boolean;
		}
}
