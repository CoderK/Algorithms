 /**
  * M * N 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열의 모든 원소를
  * 0으로 설정하는 알고리즘을 작성하라.
  */
function checkZeroElement(aRaw) {
     var aChanged = cloneArray(aRaw);

     for(var i = 0; i < aRaw.length; i++){
         for(var j = 0; j < aRaw[i].length; j++){
             if(aRaw[i][j] === 0){
                 setZeroToRowAndCol(aChanged, aRaw, i, j);
             }
         }
     }

     return aChanged;
 }

 function cloneArray(arrayA){
    var arrayB = [];

    for(var i = 0; i < arrayA.length; i++){
        arrayB[i] = arrayA[i].slice(0);
    }

     return arrayB;
 }

 function setZeroToRowAndCol(aTarget, aRaw, i, j){
     for(var k = 0; k < aRaw.length; k++){
         for(var l = 0; l < aRaw[k].length; l++){
             if(k == i || j == l){
                 aTarget[k][l] = 0;
             }
         }
     }
 }

 checkZeroElement([
     [1, 1, 0, 1],
     [1, 0, 1, 1],
     [1, 1, 1, 1],
     [1, 1, 0, 1]
 ]);

