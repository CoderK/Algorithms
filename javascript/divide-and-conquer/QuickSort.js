/*
 *1. 기준 아이템(pivot item)보다 작은 아이템들은 모두 그 앞 부분에 위치시키고, 
 *   기준 아이템보다 크거나 같은 아이템들은모두 그 뒷부분에 위치시킨다.
 *2. 기준 아이템은 어느 것이어도 상관없다.
 *3. 아이템이 하나 뿐인 배열로 분할될 때까지 이 과정을 계속 반복
 */

/*
void quickSort(   keytype S [],
                  int low , high     ) {
      index pivot ;
      
      if(low < high){
           pivot = partition( S, low , high) ;
           quickSort (S, low, pivot - 1) ;
           quickSort (S, pivot + 1 , high) ;
      }
      
}

index partition(  keytype S [],
                  int low , int high ){
      
      index i , j, pivot;
      keytype pivotItem = S[ low];
      
      j = low;
      pivot = low;
      
      for(i = low + 1; i <= high; i++){
            if(S[i] < pivotItem ) {
                 j ++
                 exchange S[j] to S[i ];
            }
      }
      
      pivot = j;
      exchange S[low] and S[pivot ];
      
      return pivot;
}
*/

(function(){
	
	function quickSort(arInput, nLow, nHigh){
		if(nLow < nHigh){
			var nPivot = partition(arInput, nLow, nHigh);
			quickSort(arInput, nLow, nPivot-1);
			quickSort(arInput, nPivot + 1, nHigh);
		}
	}
	
	function partition(arInput, nLow, nHigh){
		var 
			pivotItem = arInput[nLow],
			temp = 0,
			j = nLow,
			nPivot = nLow;
		
		for(var i = nLow+1; i <= nHigh; i++){
			if(arInput[i] < pivotItem){
				j++;
				swap(arInput, i, j);
			}
		}
		
		nPivot = j;
		swap(arInput, nPivot, nLow);
		
		return nPivot;
	}
	
	function swap(arInput, ni, nj){
		var temp = arInput[nj];
		arInput[nj] = arInput[ni];
		arInput[ni] = temp;
	}
	
	var arInputs = [ 10, 1, 2, 6, 8, 9, 13, 14, 8 ];
	quickSort(arInputs, 0, arInputs.length);
	
	console.log(arInputs);
})();
