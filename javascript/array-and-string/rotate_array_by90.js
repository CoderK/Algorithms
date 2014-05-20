//[
//    [0,1,2,3],
//    [4,5,6,7],
//    [8,9,10,11],
//    [12,13,14,15]
//]
function rotate(oldArray){
    var n = oldArray.length;
    var newArray = [];

    for(var i = 0; i < n; i++){
        for(var j = 0; j < n; j++){

            if(newArray[j] === undefined){
                newArray[j] = [];
            }

            newArray[j][n - 1 - i] = oldArray[i][j];
        }
    }

    return newArray;
}