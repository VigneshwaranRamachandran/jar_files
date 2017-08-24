/**
 * 
 */
function Delete(){
}
Delete.prototype.validate = function(fileName)
{
	if(fileName==null||fileName==""||fileName==" "){
		return "file name must";
    }
    else{
    	return "able to deleteing a file";
    }	
}
Delete.prototype.ajaxCall = function(fileName){
	if(fileName==null||fileName==""||fileName==" "){
		return "not possibel to call Ajax";
    }
    else{
    	return "possibel to call Ajax";
    }	
}
Delete.prototype.emptyField = function(boolean){
	if(boolean)
		{
		return boolean;
		}
	else
		{
		return boolean;
		}
}